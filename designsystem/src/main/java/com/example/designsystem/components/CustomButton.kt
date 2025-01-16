package com.example.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isOutlined: Boolean = false,
    enabled: Boolean = true,
    backgroundColor: Color? = null
) {
    if (isOutlined) {
        OutlinedButton(
            onClick = { if (enabled) onClick() },
            border = BorderStroke(width = 1.dp, color = RSTheme.colors.textColorPrimary),
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = RSTheme.colors.buttonTextAdditional
            )
        ) {
            Text(
                text = text,
                color = RSTheme.colors.buttonTextAdditional,
                style = RSTheme.typography.medium14
            )
        }
    } else {
        Box(
            modifier = modifier
                .clickable(enabled) { if (enabled) onClick() }
                .fillMaxWidth()
                .background(
                    color = backgroundColor ?: if (enabled) RSTheme.colors.textColorPrimary else RSTheme.colors.disabledButtonColor,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
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
}

@Preview
@Composable
fun buttonPreview(){
    CustomButton(
        modifier = Modifier.padding(top = 32.dp),
        text = stringResource(id = R.string.save_changes),
        enabled = false,
        onClick = {

        })
}

@Preview
@Composable
fun buttonPreview2(){
    CustomButton(
        modifier = Modifier.padding(top = 32.dp),
        text = stringResource(id = R.string.save_changes),
        enabled = true,
        onClick = {

        })
}

