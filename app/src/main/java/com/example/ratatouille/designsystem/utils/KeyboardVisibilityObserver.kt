package com.example.designsystem.utils

import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun KeyboardVisibilityObserver(onKeyboardVisibilityChanged: (Boolean, Dp) -> Unit) {
    val view = LocalView.current
    val density = LocalDensity.current.density

    DisposableEffect(view) {
        val onGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
            val rect = Rect()
            view.getWindowVisibleDisplayFrame(rect)
            val screenHeight = view.height
            val keyboardHeightPx = screenHeight - rect.bottom
            val keyboardHeightDp = (keyboardHeightPx / density).dp
            // 0 but 24
            onKeyboardVisibilityChanged(keyboardHeightPx < 100, keyboardHeightDp)
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener)
        }
    }
}