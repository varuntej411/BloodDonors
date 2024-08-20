package com.blood.donors.di

import com.blood.donors.data.remote.BloodDonorApiService
import com.blood.donors.data.repositoryImpl.DonorRepositoryImpl
import com.blood.donors.domain.repository.DonorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppRepositoryModule {

    @Provides
    @Singleton
    fun provideDonorRepository(bloodDonorApiService: BloodDonorApiService): DonorRepository {
        return DonorRepositoryImpl(bloodDonorApiService)
    }
}