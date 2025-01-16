package com.example.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(enabled) {
                onClick.invoke()
            }
            .fillMaxWidth()
            .background(
                color = if(enabled) RSTheme.colors.textColorPrimary else RSTheme.colors.disabledButtonColor,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = text,
            color = RSTheme.colors.buttonTextMain,
            style = RSTheme.typography.medium14,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column() {
        DefaultButton(text = "Log In", onClick = {})
    }

}