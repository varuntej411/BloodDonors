package com.blood.donors.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blood.donors.common.APIDataStatus
import com.blood.donors.domain.usecases.GetAllDonorsUseCase
import com.blood.donors.presentation.state.DonorsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getAllDonorsUseCase: GetAllDonorsUseCase
) : ViewModel() {

    private val _states = MutableStateFlow(DonorsListUiState())
    val states: StateFlow<DonorsListUiState> = _states.asStateFlow()

    // we can use *mutable-state-of* but it cannot handle large data like mutable-stateflow
    // private val _state = mutableStateOf(ProductListState())
    // val state: State<ProductListState> = _state

    init {
        getAllDonors()
    }

    fun onEvent(event: Event) {
        when(event) {
            is Event.FetchAllProducts -> {
                getAllDonors()
            }
        }
    }

    private fun getAllDonors() {
        getAllDonorsUseCase().onEach { result ->
            when (result) {
                is APIDataStatus.LOADING -> {
                    _states.update {
                        DonorsListUiState(isLoading = true)
                    }
                }

                is APIDataStatus.SUCCESS -> {
                    _states.value = DonorsListUiState(donorsModel = result.data ?: emptyList())
                }

                is APIDataStatus.ERROR -> {
                    _states.value = DonorsListUiState(error = result.message ?: "An Unexpected Error Occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}

sealed interface Event {
    data class FetchAllProducts(val id: String) : Event
}

sealed interface Navigation {

}
