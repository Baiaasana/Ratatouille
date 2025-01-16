package com.example.domain.repository


import kotlinx.coroutines.flow.Flow

interface DatastoreRepository {

    suspend fun getLanguage(): Flow<String>

    suspend fun changeLanguage(language: String)

    suspend fun getUiMode(): Flow<Int>

    suspend fun changeUiMode(uiMode: Int)

    suspend fun saveUser(user: Boolean)

    suspend fun getUser(): Boolean?

}