package com.example.ratatouille.data.repository

import com.example.domain.repository.DatastoreRepository
import com.example.ratatouille.data.local.SettingsDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class DefaultDatastoreRepository @Inject constructor(
    private val settingsDataStore: SettingsDataStore
) : DatastoreRepository {

    override suspend fun getLanguage(): Flow<String> {
        return settingsDataStore.languageStream
    }

    override suspend fun changeLanguage(language: String) {
        settingsDataStore.saveLanguage(language)
    }

    override suspend fun getUiMode(): Flow<Int> {
        return settingsDataStore.darkModeStream
    }

    override suspend fun changeUiMode(uiMode: Int) {
        settingsDataStore.saveDarkMode(uiMode)
    }

    override suspend fun saveUser(user: Boolean) {
        settingsDataStore.saveUser(user)
    }

    override suspend fun getUser(): Boolean? {
        return settingsDataStore.getUserAUthStatus().firstOrNull()
    }
}