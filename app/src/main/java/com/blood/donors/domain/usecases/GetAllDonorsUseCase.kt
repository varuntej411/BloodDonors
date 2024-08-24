package com.blood.donors.domain.usecases

import com.blood.donors.common.APIDataStatus
import com.blood.donors.data.dto.toDonorModel
import com.blood.donors.domain.model.DonorModel
import com.blood.donors.domain.repository.DonorRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllDonorsUseCase @Inject constructor(
    private val repository: DonorRepository
) {

    operator fun invoke(): Flow<APIDataStatus<List<DonorModel>>> = flow {
        try {
            emit(APIDataStatus.LOADING())
            val products = repository.getAllDonorList().map { it.toDonorModel() }
            emit(APIDataStatus.SUCCESS(products))
        } catch (e: HttpException) {
            emit(APIDataStatus.ERROR(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(APIDataStatus.ERROR(e.message ?: "Couldn't reach server, Check Your Internet Connection"))
        }
    }.flowOn(IO)


}