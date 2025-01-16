package com.example.ratatouille.designsystem.components.footer

sealed class NavigationEvent() {

    data object Home: NavigationEvent()
    data object Randomizer : NavigationEvent()
    data object Search : NavigationEvent()
}