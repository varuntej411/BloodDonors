package com.blood.donors.di

import com.blood.donors.data.BloodDonarApiService
import com.blood.donors.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule  {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
            level = HttpLoggingInterceptor.Level.BASIC
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(client: OkHttpClient) : BloodDonarApiService {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(BloodDonarApiService::class.java)
    }
}