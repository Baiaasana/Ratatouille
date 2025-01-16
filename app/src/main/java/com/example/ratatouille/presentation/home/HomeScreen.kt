package com.example.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.designsystem.components.footer.BottomNavigation

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(homeViewModel.currentMode) {
        homeViewModel.getCurrentMode()
    }

    val state by homeViewModel.homeState.collectAsStateWithLifecycle()

    HomeScreenContent(state = state)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreenContent(
    state: HomeState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = RSTheme.colors.bgColorMain)
    ) {
        Box {
            Column {
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .weight(1f)
                        .verticalScroll(rememberScrollState()) // Scrollable content
                ) {

                    Text("ssssss")
                }

                BottomNavigation(
                    bottomBarState = true
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(hiltViewModel())
}
