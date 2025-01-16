package com.example.designsystem.components.footer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratatouille.navigation.NavTarget
import com.example.ratatouille.designsystem.components.footer.NavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomNavViewModel @Inject constructor(
    private val navigator: com.example.navigation.Navigator
) : ViewModel() {

    fun handleEvents(event: NavigationEvent) {
        viewModelScope.launch {
            when (event) {
                NavigationEvent.Home -> navigator.navigateTo(NavTarget.Home)
                NavigationEvent.Search -> navigator.navigateTo(NavTarget.Search)
                NavigationEvent.Randomizer -> navigator.navigateTo(NavTarget.Randomizer)

            }
        }
    }
}