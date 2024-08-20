package com.blood.donors.domain.repository

import com.blood.donors.data.dto.DonorsDTo


interface DonorRepository {
    suspend fun getAllDonorList(): List<DonorsDTo>
}