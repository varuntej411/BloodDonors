package com.blood.donors.di

import android.content.Context
import com.blood.donors.firebase.AnalyticsHelper
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppFireBaseHelperModule {
    @Provides
    @Singleton
    fun provideFireBaseInstance(): FirebaseApp {
        return FirebaseApp.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireBaseDataBase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFireBaseAnalytics(@ApplicationContext context: Context): AnalyticsHelper {
        return AnalyticsHelper(context)
    }
}