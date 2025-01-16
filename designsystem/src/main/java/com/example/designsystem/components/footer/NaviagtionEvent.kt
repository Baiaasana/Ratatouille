package com.example.designsystem.components.footer

sealed class NavigationEvent() {

    data object Home: NavigationEvent()
    data object Profile : NavigationEvent()
    data object Bids : NavigationEvent()
    data object Auctions : NavigationEvent()
}