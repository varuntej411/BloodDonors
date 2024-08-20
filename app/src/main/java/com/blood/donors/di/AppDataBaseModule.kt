package com.blood.donors.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.blood.donors.common.UserDataStore
import com.blood.donors.common.UserDataStoreImpl
import com.blood.donors.data.local.DonorDAO
import com.blood.donors.data.local.DonorRoomDataBase
import com.blood.donors.utils.Constants.Companion.DATABASE_NAME
import com.blood.donors.utils.Constants.Companion.DATASTORE_PREF_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): DonorRoomDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = DonorRoomDataBase::class.java,
            name = DATABASE_NAME
        ).fallbackToDestructiveMigration(dropAllTables = false).build()
    }

    @Provides
    @Singleton
    fun provideDataBaseDAO(dataBase: DonorRoomDataBase): DonorDAO {
        return dataBase.getDonorsDAO()
    }

    @Provides
    @Singleton
    fun provideDataStorePreference(application: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            application.preferencesDataStoreFile(DATASTORE_PREF_NAME)
        }
    }

    @Provides
    @Singleton
    fun provideDataStore(dataStore: DataStore<Preferences>) : UserDataStore {
        return UserDataStoreImpl(dataStore)
    }

}