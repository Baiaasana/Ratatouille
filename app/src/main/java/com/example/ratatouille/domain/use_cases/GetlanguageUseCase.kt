package com.example.ratatouille.domain.use_cases

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.LocaleList
import com.example.domain.repository.DatastoreRepository
import kotlinx.coroutines.flow.Flow
import java.util.Locale
import javax.inject.Inject

class GetSettingsUseCase @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) {

    suspend fun getLanguage(): Flow<String> {
        return datastoreRepository.getLanguage()
    }

    private suspend fun changeLanguage(languageCode: String) {
        datastoreRepository.changeLanguage(languageCode)
    }

    suspend fun getUiMode(): Flow<Int> {
        return datastoreRepository.getUiMode()
    }

    suspend fun changeUiMode(uiMode: Int) {
        datastoreRepository.changeUiMode(uiMode)
    }


    suspend fun setAppLanguage(context: Context, languageCode: String) {
        setLocale(context, languageCode)
        changeLanguage(languageCode)
        restartActivity(context)
    }

    suspend fun setAppLanguageWithoutRestart(context: Context, languageCode: String) {
        setLocale(context, languageCode)
        changeLanguage(languageCode)
    }

    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = context.resources
        val config = resources.configuration

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocales(LocaleList(locale))
        } else {
            config.locale = locale
        }
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    // Restart the current activity
    fun restartActivity(context: Context) {
        val intent = (context as Activity).intent
        context.finish()
        context.startActivity(intent)
    }
}