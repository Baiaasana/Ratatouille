package com.example.ratatouille.navigation

import kotlinx.serialization.Serializable

sealed class NavTarget() {

    @Serializable
    data object OnBoarding : NavTarget()

    @Serializable
    data object Search : NavTarget()

    @Serializable
    data object AuthSignUp : NavTarget()

    @Serializable
    data object AuthSignIn : NavTarget()

    @Serializable
    data object Home : NavTarget()

    @Serializable
    data object Randomizer : NavTarget()

    @Serializable
    data object PrivacyPolicy : NavTarget()

}


