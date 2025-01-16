package com.example.designsystem.components.fields

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.data.constants.Constants.EMAIL_REGEX
import com.example.designsystem.theme.RSTheme
import java.util.regex.Pattern

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    singleLine: Boolean = true,
    fieldType: FieldType = FieldType.Text,
    isEnabled: Boolean = true,
    withIcon: Boolean = false,
) {

    val supportingText = when {
        fieldType == FieldType.Text && textFieldValue.isEmpty() ->
            stringResource(id = com.example.designsystem.R.string.empty_input)

        fieldType == FieldType.EmailOrPhone && textFieldValue.contains("@") && !android.util.Patterns.EMAIL_ADDRESS.matcher(
            textFieldValue
        ).matches() ->
            stringResource(id = com.example.designsystem.R.string.invalid_format)

        fieldType == FieldType.EmailOrPhone && !textFieldValue.contains("@") && textFieldValue.isDigitsOnly() && textFieldValue.isNotEmpty() ->
            stringResource(id = com.example.designsystem.R.string.invalid_format)

        fieldType == FieldType.Email &&
//                Patterns.EMAIL_ADDRESS.matcher(textFieldValue).matches()
                Pattern.compile(EMAIL_REGEX)
                            .matcher(textFieldValue)
                            .matches() &&
                               (textFieldValue.isNotEmpty() && textFieldValue.first().isLetter())


        -> stringResource(id = com.example.designsystem.R.string.invalid_format)

        fieldType == FieldType.Phone && !android.util.Patterns.EMAIL_ADDRESS.matcher(textFieldValue)
            .matches() -> stringResource(id = com.example.designsystem.R.string.invalid_format)

        else -> stringResource(id = com.example.designsystem.R.string.invalid_format)
    }

    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            enabled = isEnabled,
            singleLine = singleLine,
            value = textFieldValue,
            isError = isError,
            onValueChange = { value ->
                Log.d("onvaluechange", "change")
                onValueChange(value)
            },
            label = { Text(text = label, style = RSTheme.typography.regular14) },
            textStyle = RSTheme.typography.regular14,
            colors = TextFieldDefaults.colors(
                focusedTextColor = RSTheme.colors.textColorMain,
                focusedIndicatorColor = RSTheme.colors.outlineActive,
                unfocusedTextColor = RSTheme.colors.textColorMain,
                unfocusedLabelColor = RSTheme.colors.textColorMain,
                unfocusedIndicatorColor = RSTheme.colors.outlineInActive,
                cursorColor = RSTheme.colors.textColorPrimary,
                focusedLabelColor = RSTheme.colors.textColorPrimary,
                errorLabelColor = RSTheme.colors.errorColor,
                errorTextColor = RSTheme.colors.errorColor,
                disabledTextColor = RSTheme.colors.outlineInActive,
                disabledLabelColor = RSTheme.colors.outlineInActive,
                disabledTrailingIconColor = RSTheme.colors.outlineInActive,
                disabledIndicatorColor = RSTheme.colors.outlineInActive,
                errorContainerColor = RSTheme.colors.bgColorMain,
                disabledContainerColor = RSTheme.colors.bgColorMain,
                focusedContainerColor = RSTheme.colors.bgColorMain,
                unfocusedContainerColor = RSTheme.colors.bgColorMain,
                unfocusedTrailingIconColor = RSTheme.colors.greenDark,
                focusedTrailingIconColor = RSTheme.colors.greenDark
            ),
            shape = RoundedCornerShape(8),
            trailingIcon = {
                val condition = when (fieldType) {
                    FieldType.Text -> {
                        textFieldValue.isNotEmpty()
                    }

                    FieldType.EmailOrPhone -> {
                        if (textFieldValue.drop(1).all { it.isDigit() }) {
                            // Phone number detected, so show check icon if it's not empty
                            textFieldValue.startsWith("+") && textFieldValue.length > 1
                        } else {
                            // Email address detected, so validate as email
                            Patterns.EMAIL_ADDRESS.matcher(textFieldValue).matches()
                        }
                    }

                    FieldType.Email -> {
//                        Patterns.EMAIL_ADDRESS.matcher(textFieldValue).matches()

                        Pattern.compile(
                            EMAIL_REGEX
                        ).matcher(textFieldValue).matches() && (textFieldValue.isNotEmpty() && textFieldValue.first().isLetter())
                    }

                    FieldType.Phone -> {
                        textFieldValue.isNotEmpty()
                    }

                }
                if (condition && withIcon) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                }
            })

        if (isError) {
            ErrorMessage(text = supportingText)
        }
    }
}

enum class FieldType {
    EmailOrPhone, Text, Email, Phone
}


@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier, text: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = RSTheme.icons.icError),
            contentDescription = null,
            alignment = Alignment.Center
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = text,
            style = RSTheme.typography.regular14,
            color = RSTheme.colors.errorColor,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ErrorMessagePreview() {
    ErrorMessage(text = "ddd")
}

@Preview(showBackground = true)
@Composable
fun dsdsdsPreview() {
    MyTextField(label = "ddd", onValueChange = { _ -> }, textFieldValue = "dd")
}