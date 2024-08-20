package com.blood.donors.common

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow


val USER_ID = intPreferencesKey("user_id")
val USER_NAME = stringPreferencesKey("user_name")
val USER_SESSION = stringPreferencesKey("user_session")
val USER_TOKEN = stringPreferencesKey("user_token")
val isUserLoggedIn = booleanPreferencesKey("isUSerLoggedIn")

interface UserDataStore {

    fun getUserId(): Flow<Int>
    suspend fun saveUserId(id: Int)
    suspend fun deleteUserId()

    fun getUserName(): Flow<String>
    suspend fun saveUserName(name: String)
    suspend fun deleteUserName()

    fun getUserSession(): Flow<String>
    suspend fun saveUserSession(session: String)
    suspend fun deleteUserSession()

    fun getUserToken(): Flow<String>
    suspend fun saveUserToken(token: String)
    suspend fun deleteUserToken()

    fun getUSerLoggedIn(): Flow<Boolean>
    suspend fun saveUSerLoggedIn(isLoggedIn: Boolean)
    suspend fun deleteUSerLoggedIn()

}