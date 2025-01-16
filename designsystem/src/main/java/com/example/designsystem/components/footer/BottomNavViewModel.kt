package com.example.designsystem.components.footer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigator
import com.example.navigation.NavTarget
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomNavViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun handleEvents(event: NavigationEvent) {
        viewModelScope.launch {
            when (event) {
                NavigationEvent.Auctions -> navigator.navigateTo(NavTarget.LiveAuctions)
                NavigationEvent.Bids -> navigator.navigateTo(NavTarget.BidHistory)
                NavigationEvent.Home -> navigator.navigateTo(NavTarget.Home)
                NavigationEvent.Profile -> navigator.navigateTo(NavTarget.Profile)
            }
        }
    }
}