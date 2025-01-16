package com.example.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal val LocalBrushes = staticCompositionLocalOf { CustomBrushes() }

fun horizontalBrush(color1: Color, color2: Color) =
    Brush.sweepGradient(listOf(color1, color2))


fun verticalBrush(color1: Color, color2: Color) =
    Brush.verticalGradient(listOf(color1, color2))

data class CustomBrushes(
    val buttonBrush: Brush = horizontalBrush(Color.Yellow, Color.Blue),
    val leaderBoardBrush: Brush = verticalBrush(
        Color(0xFFB36EC4),
        Color(0xFF64B0F9)
    )
)

