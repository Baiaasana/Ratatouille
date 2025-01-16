package com.example.ratatouille.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.designsystem.components.policy.PrivacyPolicyScreen
import com.example.presentation.home.HomeScreen
import com.example.presentation.home.HomeState
import com.example.presentation.on_boarding.OnBoardingScreen
import com.example.ratatouille.presentation.randomizer.RandomizerScreen
import com.example.ratatouille.presentation.search.SearchScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
fun NavGraphBuilder.addNavGraph(popBackStack: () -> Unit) {

    composable<NavTarget.OnBoarding> {
        OnBoardingScreen(hiltViewModel())
    }

    composable<NavTarget.PrivacyPolicy> {
        PrivacyPolicyScreen { popBackStack() }
    }

    composable<NavTarget.Home> {
        HomeScreen(hiltViewModel())
    }

    composable<NavTarget.Randomizer> {
        RandomizerScreen(hiltViewModel())
    }

    composable<NavTarget.Search> {
        SearchScreen(hiltViewModel())
    }

}


