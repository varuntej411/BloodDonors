package com.blood.donors.data

import retrofit2.http.GET

interface BloodDonarApiService {

    @GET
    suspend fun getAllDonars()
}