package com.example.ratatouille.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.Navigator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun NavigationComponent(
    modifier: Modifier,
    navController: NavHostController,
    navigator: Navigator,
    startDestination: Any
) {
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            navController.navigate(it) {
                Log.d("navigation", "it  $it")
                popUpTo(it) {
                    if (it == NavTarget.OnBoarding || it == NavTarget.Home)
                        Log.d("navigation", "inclusive  $it")
                    inclusive = true
                }
            }
        }.launchIn(this)
    }
    Column(modifier = modifier) {
        NavHost(
            navController = navController, startDestination = startDestination
        ) {
            addNavGraph { navController.popBackStack() }
        }
    }
}