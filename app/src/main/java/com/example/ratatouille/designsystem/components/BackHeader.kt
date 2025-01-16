package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.R

@Composable
fun BackHeader(
    modifier: Modifier = Modifier,
    labelId: Int,
    backAction: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back arrow aligned to the left
        Image(
            imageVector = ImageVector.vectorResource(RSTheme.icons.icBackArrow),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = RSTheme.colors.textColorMain),
            modifier = Modifier.clickable {
                backAction.invoke()
            }
        )

        // A Box fills the entire width and centers the Text horizontally
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center // Ensure the Text is centered within the Box
        ) {
            Text(
                text = stringResource(id = labelId),
                textAlign = TextAlign.Center,
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.medium18
            )
        }
    }
}


@Preview
@Composable
fun BackHeaderPreview() {
    BackHeader(labelId = R.string.settings, backAction = {})
}