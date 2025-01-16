package com.example.ratatouille.designsystem.components.footer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.designsystem.components.footer.BottomNavViewModel
import com.example.designsystem.components.footer.BottomScreens
import com.example.designsystem.theme.RSTheme

@Composable
fun BottomNavigation(
    viewModel: BottomNavViewModel = hiltViewModel(),
    bottomBarState: Boolean = true
) {

    val navController = rememberNavController()

    BottomNavigationContent(
        navController = navController,
        onEvent = { event ->
            viewModel.handleEvents(event)
        },
        bottomBarState = bottomBarState
    )
}

@Composable
fun BottomNavigationContent(
    onEvent: (NavigationEvent) -> Unit,
    navController: NavController,
    bottomBarState: Boolean,
) {
    AnimatedVisibility(
        visible = bottomBarState,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            val bottomScreens = remember {
                listOf(
                    BottomScreens.Home,
                    BottomScreens.Randomizer,
                    BottomScreens.Search,
                )
            }

            Column {
                Divider(color = RSTheme.colors.strokeGray, thickness = 1.dp)
                NavigationBar(
                    modifier = Modifier
                        .navigationBarsPadding(),
                    containerColor = RSTheme.colors.bgColorMain,
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    bottomScreens.forEach { screen ->
                        val isSelected =
                            currentDestination?.hierarchy?.any { it.route == screen.route::class.qualifiedName } == true
                        NavigationBarItem(
                            modifier = Modifier.background(color = RSTheme.colors.bgColorMain),
                            selected = isSelected,
                            onClick = {
                                when (screen) {
                                    BottomScreens.Home -> onEvent.invoke(NavigationEvent.Home)
                                    BottomScreens.Search -> onEvent.invoke(NavigationEvent.Search)
                                    BottomScreens.Randomizer -> onEvent.invoke(NavigationEvent.Randomizer)
                                    else -> {}
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = ImageVector.vectorResource(screen.icon),
                                    contentDescription = stringResource(id = screen.name),
                                )
                            },
                            label = {
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = stringResource(id = screen.name),
                                    style = RSTheme.typography.medium12,
                                    color = if (isSelected) RSTheme.colors.textColorPrimary else RSTheme.colors.textColorMain
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = RSTheme.colors.textColorPrimary, // Your selected icon color
                                unselectedIconColor = RSTheme.colors.textColorMain, // Your unselected icon color
                                indicatorColor = RSTheme.colors.bgColorMain,// Background color of selected icon
                                selectedTextColor = RSTheme.colors.textColorPrimary,
                                unselectedTextColor = RSTheme.colors.textColorMain,
                            )
                        )
                    }
                }
            }
        }
    )
}