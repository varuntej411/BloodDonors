package com.blood.donors.data.remote

import com.blood.donors.data.dto.DonorsDTo
import retrofit2.http.GET

interface BloodDonorApiService {

    @GET
    suspend fun getAllDonors(): List<DonorsDTo>
}