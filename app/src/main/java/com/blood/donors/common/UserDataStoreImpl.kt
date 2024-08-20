package com.blood.donors.common

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserDataStoreImpl(private val dataStore: DataStore<Preferences>) : UserDataStore {

    override fun getUserId(): Flow<Int> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_ID] ?: 0
        }
    }

    override suspend fun saveUserId(id: Int) {
        dataStore.edit { pref ->
            pref[USER_ID] = id
        }
    }

    override suspend fun deleteUserId() {
        dataStore.edit { pref ->
            pref.remove(USER_ID)
        }
    }

    override fun getUserName(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_NAME] ?: ""
        }
    }

    override suspend fun saveUserName(name: String) {
        dataStore.edit { pref ->
            pref[USER_NAME] = name
        }
    }

    override suspend fun deleteUserName() {
        dataStore.edit { pref ->
            pref.remove(USER_NAME)
        }
    }

    override fun getUserSession(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_SESSION] ?: ""
        }
    }

    override suspend fun saveUserSession(session: String) {
        dataStore.edit { pref ->
            pref[USER_SESSION] = session
        }
    }

    override suspend fun deleteUserSession() {
        dataStore.edit { pref ->
            pref.remove(USER_SESSION)
        }
    }

    override fun getUserToken(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_TOKEN] ?: ""
        }
    }

    override suspend fun saveUserToken(token: String) {
        dataStore.edit { pref ->
            pref[USER_TOKEN] = token
        }
    }

    override suspend fun deleteUserToken() {
        dataStore.edit { pref ->
            pref.remove(USER_TOKEN)
        }
    }

    override fun getUSerLoggedIn(): Flow<Boolean> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[isUserLoggedIn] ?: false
        }
    }

    override suspend fun saveUSerLoggedIn(isUserLogin: Boolean) {
        dataStore.edit { pref ->
            pref[isUserLoggedIn] = isUserLogin
        }
    }

    override suspend fun deleteUSerLoggedIn() {
        dataStore.edit { pref ->
            pref.remove(isUserLoggedIn)
        }
    }

}