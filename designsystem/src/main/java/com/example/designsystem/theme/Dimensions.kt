package com.example.designsystem.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val xxs: Dp = 1.dp,
    val xs: Dp = 4.dp,
    val s: Dp = 8.dp,
    val m: Dp = 12.dp,
    val l: Dp = 16.dp,
    val xl: Dp = 20.dp,
    val xl2: Dp = 24.dp,
    val xl3: Dp = 32.dp,
    val xl4: Dp = 36.dp,
    val noSpacing: Dp = 0.dp,
    val spacing0: Dp = 2.dp,
    val spacing1: Dp = 4.dp,
    val spacing2: Dp = 8.dp,
    val spacing3: Dp = 12.dp,
    val spacing4: Dp = 16.dp,
    val spacing5: Dp = 20.dp,
    val spacing6: Dp = 24.dp,
    val spacing7: Dp = 32.dp,
    val spacing8: Dp = 40.dp,
    val spacing9: Dp = 48.dp,
    val spacing10: Dp = 56.dp,
    val spacing11: Dp = 64.dp,
    val spacing12: Dp = 80.dp,

    val navigationBarHeight: Dp = 80.dp,
    val primaryButtonHeight: Dp = 52.dp,
    val secondaryButtonHeight: Dp = 44.dp,
    val iconTextButtonHeight: Dp = 36.dp,
    val iconSize: Dp = 32.dp,

    val outlinedButtonHeight: Dp = 56.dp,

    val primaryInputHeight: Dp = 52.dp,
    val pagerIndicatorSize: Dp = 6.dp,
)

val LocalSpacing = compositionLocalOf { Dimensions() }
