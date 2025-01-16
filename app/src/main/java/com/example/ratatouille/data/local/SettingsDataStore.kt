package com.example.ratatouille.data.local


import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.ratatouille.data.Constants.DARK_MODE
import com.example.ratatouille.data.Constants.IS_AUTHORIZED
import com.example.ratatouille.data.Constants.LANGUAGE
import com.example.ratatouille.data.Constants.SETTINGS
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsDataStore @Inject constructor(
    @ApplicationContext val context: Context
) {
    private val Context.dataStore by preferencesDataStore(SETTINGS)
    private val DARK_MODE_KEY = intPreferencesKey(DARK_MODE)
    private val LANGUAGE_KEY = stringPreferencesKey(LANGUAGE)
    private val IS_AUTHORIZED_KEY = booleanPreferencesKey(IS_AUTHORIZED)

    val darkModeStream: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[DARK_MODE_KEY] ?: 7
    }

    val isAuthorizedStream: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_AUTHORIZED_KEY] ?: false
    }

    val languageStream: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[LANGUAGE_KEY] ?: "en"
    }

    fun getUserAUthStatus(): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[IS_AUTHORIZED_KEY]
        }
    }

    suspend fun saveDarkMode(isLightMode: Int) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = isLightMode
        }
    }

    suspend fun saveLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE_KEY] = language
        }
    }

    suspend fun saveUser(user: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_AUTHORIZED_KEY] = user
        }
    }

}
