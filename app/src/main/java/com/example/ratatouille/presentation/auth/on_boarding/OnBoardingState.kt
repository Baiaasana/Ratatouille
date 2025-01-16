package com.example.presentation.on_boarding

import android.content.Context

data class OnBoardingState(
    val currentLanguage: String = "en",
)

sealed class OnBoardingEvent() {
    data object PolicyClick : OnBoardingEvent()
    data class ChangeLanguage(val context: Context, val language: String) : OnBoardingEvent()
    data object NavigateToSignIn : OnBoardingEvent()
    data object NavigateToHome : OnBoardingEvent()
    data object NavigateToSignUp : OnBoardingEvent()
}