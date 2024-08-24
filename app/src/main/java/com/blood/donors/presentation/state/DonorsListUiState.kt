package com.blood.donors.presentation.state

import com.blood.donors.domain.model.DonorModel

data class DonorsListUiState(
    val isLoading: Boolean = false,
    val donorsModel: List<DonorModel> = emptyList(),
    val error: String = ""
)