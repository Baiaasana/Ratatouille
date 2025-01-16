package com.example.designsystem.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme


// nana
@Composable
fun MyOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { onClick() },
        border = BorderStroke(width = 1.dp, color = RSTheme.colors.textColorPrimary),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(
            text = text,
            color = RSTheme.colors.buttonTextAdditional,
            style = RSTheme.typography.medium14)
    }
}

@Preview(showBackground = true)
@Composable
fun MyOutlinedButtonPreview() {
    MyOutlinedButton(text = "I'm a new user, sign me up", onClick = {})
}
