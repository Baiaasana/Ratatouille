package com.example.ratatouille.app

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.theme.RSTheme
import com.example.designsystem.theme.RatatouilleTheme
import com.example.navigation.Navigator
import com.example.ratatouille.navigation.NavTarget
import com.example.ratatouille.navigation.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavHostController

    @Inject
    lateinit var navigator: Navigator

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.isUserAuthorized()
        viewModel.getLanguage(this)
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUiModel()
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            RatatouilleTheme {
                UpdateStatusBarColor(this)
                val mainState by viewModel.mainState.collectAsStateWithLifecycle()
                Log.d("mainState", "authorized ${mainState}")
                navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val bottomBarState = rememberSaveable { (mutableStateOf(false)) }

                if (navBackStackEntry != null) {
                    when (navBackStackEntry?.destination?.route.toString()
                        .substringAfterLast(".")) {

                        NavTarget.Home.toString() -> {
                            bottomBarState.value = true
                        }

                        NavTarget.Search.toString() -> {
                            bottomBarState.value = true
                        }

                        NavTarget.Randomizer.toString() -> {
                            bottomBarState.value = true
                        }

                        else -> bottomBarState.value = false
                    }
                }

                Scaffold { innerPadding ->
                    NavigationComponent(
                        modifier = Modifier
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                            )
                            .navigationBarsPadding(),
                        navController = navController,
                        navigator = navigator,
//                        startDestination = NavTarget.OnBoarding
                        startDestination = if (mainState.isUserAuthorized == false || mainState.isUserAuthorized == null) NavTarget.OnBoarding else NavTarget.Home
                    )
                }
            }
        }
    }
}

@Composable
fun UpdateStatusBarColor(context: Context) {
    val darkTheme = isSystemInDarkTheme()
    val statusBarColor = RSTheme.colors.bgColorMain
    SideEffect {
        val window = (context as Activity).window
        window.statusBarColor = statusBarColor.toArgb()
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            !darkTheme
    }
}
