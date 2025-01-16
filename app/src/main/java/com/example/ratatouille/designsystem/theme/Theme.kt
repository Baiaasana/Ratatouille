package com.example.designsystem.theme

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object RSTheme {
    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = CustomTypography()

    val dimensions: Dimensions
        @Composable
        @ReadOnlyComposable
        get() = Dimensions()

    val colors: CustomColorsPalette
        @Composable
        @ReadOnlyComposable
        get() = if (isNightMode()) DarkCustomColorsPalette else LightCustomColorsPalette


    val brushes: CustomBrushes
        @Composable
        @ReadOnlyComposable
        get() = LocalBrushes.current

    val icons: Icons
        @Composable
        @ReadOnlyComposable
        get() = if (isNightMode()) DarkIcons else LightIcons

}

@Composable
@ReadOnlyComposable
fun isNightMode() = when (AppCompatDelegate.getDefaultNightMode()) {
    AppCompatDelegate.MODE_NIGHT_NO -> false
    AppCompatDelegate.MODE_NIGHT_YES -> true
    else -> isSystemInDarkTheme()
}

@Composable
fun RatatouilleTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalPalette provides RSTheme.colors,
        LocalSpacing provides RSTheme.dimensions,
        LocalTypography provides RSTheme.typography,
        LocalBrushes provides RSTheme.brushes,
        LocalIcons provides RSTheme.icons,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}