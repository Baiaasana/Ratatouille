package com.example.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme

@Composable
fun Tabs(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Row {
        tabs.forEachIndexed { index, tab ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(32.dp)
                    .clickable { onTabSelected(index) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = tab,
                        style = RSTheme.typography.regular12,
                        color = if (index == selectedTabIndex) {
                            RSTheme.colors.textColorMain
                        } else {
                            RSTheme.colors.textColorAdditional
                        },
                        textAlign = TextAlign.Center
                    )
                }

                if (index == selectedTabIndex) {
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(color = RSTheme.colors.textColorPrimary),
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun TabsPreview() {
    Tabs(
        listOf("დდდ", "სსს")
        ,1,{}
    )
}