package com.example.designsystem.components.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme

@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
    enabled: Boolean = false,
    onValueChange: (String) -> Unit,
) {

    var revealPassword by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        if (!value.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = label,
                style = RSTheme.typography.medium14,
                color = RSTheme.colors.textColorMain
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(48.dp)
                .border(
                    width = 1.dp,
                    color = RSTheme.colors.profileFieldBorder,
                    shape = RoundedCornerShape(8.dp)
                ),
            shape = RoundedCornerShape(8.dp),
            value = value ?: "",
            placeholder = {
                if (value.isNullOrEmpty()) {
                    Text(
                        text = label,
                        style = RSTheme.typography.regular12,
                        color = RSTheme.colors.textColorMain
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = RSTheme.colors.textColorMain,
                focusedIndicatorColor = RSTheme.colors.outlineActive,
                unfocusedTextColor = RSTheme.colors.textColorMain,
                unfocusedLabelColor = RSTheme.colors.textColorMain,
                unfocusedIndicatorColor = RSTheme.colors.outlineInActive,
                cursorColor = RSTheme.colors.textColorPrimary,
                focusedLabelColor = RSTheme.colors.textColorPrimary,
                focusedTrailingIconColor = RSTheme.colors.textColorMain,
                focusedContainerColor = RSTheme.colors.bgColorMain,
                unfocusedContainerColor = RSTheme.colors.bgColorMain,
                unfocusedTrailingIconColor = RSTheme.colors.textColorMain,
                disabledTextColor = RSTheme.colors.textColorMain,
                disabledLeadingIconColor = RSTheme.colors.textColorMain,
                disabledTrailingIconColor = RSTheme.colors.textColorMain,
                disabledLabelColor = RSTheme.colors.textColorMain,
                disabledIndicatorColor = RSTheme.colors.textColorMain,
                disabledContainerColor = RSTheme.colors.bgColorMain,
            ),
            visualTransformation = if (revealPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            enabled = enabled,
            textStyle = RSTheme.typography.regular12,
            trailingIcon = {
                IconButton(
                    onClick = {
                        revealPassword = !revealPassword
                    },
                ) {
                    val icon = if (revealPassword) {
                        painterResource(id = RSTheme.icons.icEyeVisible)
                    } else {
                        painterResource(id = RSTheme.icons.icNoEye)
                    }
                    Icon(painter = icon, contentDescription = null)
                }
            },
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PasswordFieldPreview() {
    PasswordField(
        modifier = Modifier,
        label = stringResource(id = R.string.password),
        value = "",
        enabled = true,
        onValueChange = {},
    )
}
