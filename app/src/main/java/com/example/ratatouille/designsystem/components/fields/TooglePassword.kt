package com.example.designsystem.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.R
import com.example.ratatouille.data.Constants


@Composable
fun TogglePassword(
    modifier: Modifier = Modifier,
    label: String,
    isError: Boolean = false,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    isEnabled: Boolean = true
) {

    var revealPassword by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            enabled = isEnabled,
            singleLine = singleLine,
            value = textFieldValue,
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
            isError = isError,
            label = { Text(text = label, style = RSTheme.typography.regular14) },
            textStyle = RSTheme.typography.regular14,
            colors = TextFieldDefaults.colors(
                focusedTextColor = RSTheme.colors.textColorMain,
                focusedIndicatorColor = RSTheme.colors.outlineActive,
                unfocusedTextColor = RSTheme.colors.textColorMain,
                errorIndicatorColor = RSTheme.colors.errorColor,
                unfocusedIndicatorColor = RSTheme.colors.outlineInActive,
                cursorColor = RSTheme.colors.textColorPrimary,
                unfocusedLabelColor = RSTheme.colors.textColorMain,
                focusedLabelColor = RSTheme.colors.textColorPrimary,
                errorLabelColor = RSTheme.colors.errorColor,
                errorTextColor = RSTheme.colors.errorColor,
                disabledTextColor = RSTheme.colors.outlineInActive,
                disabledLabelColor = RSTheme.colors.outlineInActive,
                disabledTrailingIconColor = RSTheme.colors.outlineInActive,
                disabledIndicatorColor = RSTheme.colors.outlineInActive,
                errorTrailingIconColor = RSTheme.colors.textColorMain,
                unfocusedContainerColor = RSTheme.colors.bgColorMain,
                focusedContainerColor = RSTheme.colors.bgColorMain,
                errorContainerColor = RSTheme.colors.bgColorMain,
                disabledContainerColor = RSTheme.colors.bgColorMain,
                unfocusedTrailingIconColor = RSTheme.colors.textColorMain,
                focusedTrailingIconColor = RSTheme.colors.textColorMain
            ),
            shape = RoundedCornerShape(8),
            visualTransformation = if (revealPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
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
            }
        )

        if (isError) {
            ErrorMessage(text = stringResource(id = R.string.invalid_format))
        }
    }
}


@Composable
fun PasswordStrengthChecks(
    password: String
) {
    val validate = validatePassword(password)
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .background(color = RSTheme.colors.bgGray, shape = RoundedCornerShape(8.dp))
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp, start = 8.dp, bottom = 4.dp),
            text = stringResource(id = R.string.password_checks),
            style = RSTheme.typography.regular12,
            color = RSTheme.colors.textColorMain
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(id = R.string.check_lower),
            style = RSTheme.typography.regular12,
            color = if (validate.isLower) RSTheme.colors.greenDark else RSTheme.colors.textColorMain
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(id = R.string.check_upper),
            style = RSTheme.typography.regular12,
            color = if (validate.isUpper) RSTheme.colors.greenDark else RSTheme.colors.textColorMain
        )
        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = stringResource(id = R.string.check_number),
            style = RSTheme.typography.regular12,
            color = if (validate.isNumber) RSTheme.colors.greenDark else RSTheme.colors.textColorMain
        )
        Text(
            modifier = Modifier.padding(start = 12.dp, bottom = 16.dp),
            text = stringResource(id = R.string.check_special),
            style = RSTheme.typography.regular12,
            color = if (validate.isSpecial) RSTheme.colors.greenDark else RSTheme.colors.textColorMain
        )
    }
}

data class PasswordValidates(
    val isUpper: Boolean = false,
    val isLower: Boolean = false,
    val isNumber: Boolean = false,
    val isSpecial: Boolean = false,
)

private fun validatePassword(password: String): PasswordValidates {
    return PasswordValidates(
        isUpper = password.any { char -> char.isUpperCase() },
        isLower = password.any { char -> char.isLowerCase() },
        isNumber = password.any { char -> char.isDigit() },
        isSpecial = password.any { char -> char in Constants.SPECIAL_CHARACTERS }
    )
}