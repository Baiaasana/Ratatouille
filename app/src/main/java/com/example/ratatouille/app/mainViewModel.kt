package com.example.ratatouille.app

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratatouille.domain.use_cases.AuthUseCase
import com.example.ratatouille.domain.use_cases.GetSettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSettingsUseCase: GetSettingsUseCase,
    private val jwtTokensUseCase: AuthUseCase,
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    fun isUserAuthorized() {
        viewModelScope.launch {
            _mainState.update {
                it.copy(
                    isUserAuthorized = jwtTokensUseCase.getUser()
                )
            }
        }
    }

    fun getLanguage(content: Context) {
        viewModelScope.launch {
            getSettingsUseCase.getLanguage().collectLatest {
                getSettingsUseCase.setAppLanguageWithoutRestart(context = content, it)
            }
        }
    }

    fun getUiModel() {
        viewModelScope.launch {
            getSettingsUseCase.getUiMode().collect {
                Log.d("getDefaultNightMode", "vm $it")
                AppCompatDelegate.setDefaultNightMode(it)
//                getSettingsUseCase.restartActivity(context)
            }
        }
    }
}

