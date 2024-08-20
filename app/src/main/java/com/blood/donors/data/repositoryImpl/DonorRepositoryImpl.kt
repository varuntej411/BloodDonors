package com.blood.donors.data.repositoryImpl

import com.blood.donors.data.dto.DonorsDTo
import com.blood.donors.data.remote.BloodDonorApiService
import com.blood.donors.domain.repository.DonorRepository
import javax.inject.Inject

class DonorRepositoryImpl @Inject constructor(
    private val bloodDonorApiService: BloodDonorApiService
) : DonorRepository {

    override suspend fun getAllDonorList(): List<DonorsDTo> {
        return bloodDonorApiService.getAllDonors()
    }

}