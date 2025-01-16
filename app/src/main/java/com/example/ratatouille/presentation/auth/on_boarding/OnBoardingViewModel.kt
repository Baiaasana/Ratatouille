package com.example.presentation.on_boarding


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratatouille.domain.use_cases.GetSettingsUseCase
import com.example.ratatouille.navigation.NavTarget
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewmodel @Inject constructor(
    private val navigator: Navigator,
    private val getSettingsUseCase: GetSettingsUseCase,
    ) : ViewModel() {

    private val _onBoardingState = MutableStateFlow(OnBoardingState())
    val onBoardingState: StateFlow<OnBoardingState> = _onBoardingState.asStateFlow()

    init {
        getLanguage()
    }

    fun handleEvents(event: OnBoardingEvent) {
        viewModelScope.launch {
            when (event) {

                OnBoardingEvent.PolicyClick -> {
                    navigator.navigateTo(NavTarget.PrivacyPolicy)
                }

                is OnBoardingEvent.ChangeLanguage -> {
                    changeLanguage(event.context, event.language)
                }

                OnBoardingEvent.NavigateToSignIn -> {
                    navigateToSignIn()
                }

                OnBoardingEvent.NavigateToHome -> {
                    navigator.navigateTo(NavTarget.Home)

                }

                OnBoardingEvent.NavigateToSignUp -> {
                    navigateToSignUp()
                }

                else -> {}
            }
        }
    }


    private fun navigateToSignIn() {
        navigator.navigateTo(NavTarget.AuthSignIn)
    }

    private fun navigateToSignUp() {
        navigator.navigateTo(NavTarget.AuthSignUp)
    }


    private fun getLanguage() {
        viewModelScope.launch {
            getSettingsUseCase.getLanguage().collectLatest { current ->
                _onBoardingState.update { it.copy(currentLanguage = current) }
            }
        }
    }

    private fun changeLanguage(content: Context, language: String) {
        viewModelScope.launch {
            getSettingsUseCase.setAppLanguageWithoutRestart(content, language)
        }
    }
}
