package com.example.designsystem.components.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme

@Composable
fun UserInfoField(
    modifier: Modifier = Modifier,
    leadingIcon: Int? = null,
    trailingIcon: Int? = null,
    label: String,
    hint: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
    mustAdd: Boolean = false,
    value: String?,
    fullSize: Boolean = false,
    enabled: Boolean = false,
    onValueChange: (String) -> Unit,
    onIconCLick: () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = label,
            style = RSTheme.typography.medium14,
            color = RSTheme.colors.textColorMain
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .then(if (fullSize) Modifier.fillMaxHeight() else Modifier.height(48.dp))
                .border(
                    width = 1.dp,
                    color = RSTheme.colors.profileFieldBorder,
                    shape = RoundedCornerShape(8.dp)
                ),
            keyboardOptions = keyboardOptions,
            shape = RoundedCornerShape(8.dp),
            value = value ?: "",
            leadingIcon = leadingIcon?.let { id ->
                {
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = null
                    )
                }
            },
            placeholder = {
                if (value.isNullOrEmpty()) {
                    if (mustAdd) {
                        Text(
                            text = stringResource(id = R.string.please_add).plus(
                                " "
                            )
                                .plus(label),
                            style = RSTheme.typography.regular12,
                            color = RSTheme.colors.textColorMain
                        )
                    } else if (hint.isNotEmpty()) {
                        Text(
                            text = hint,
                            style = RSTheme.typography.regular12,
                            color = RSTheme.colors.textColorMain
                        )
                    } else {
                        Text(
                            text = label,
                            style = RSTheme.typography.regular12,
                            color = RSTheme.colors.textColorMain
                        )
                    }
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
            enabled = enabled,
            textStyle = RSTheme.typography.regular12,
            trailingIcon = trailingIcon?.let { id ->
                {
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = null, modifier = Modifier.clickable { onIconCLick() }
                    )
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
fun UserInfoFieldPreview3() {
    UserInfoField(modifier = Modifier,
        leadingIcon = RSTheme.icons.icDown,
        trailingIcon = RSTheme.icons.icSearch,
        label = stringResource(id = R.string.nickname),
        value = "dfdfd",
        enabled = true,
        onValueChange = {},
        onIconCLick = {})
}

@Preview(showBackground = true)
@Composable
fun UserInfoFieldPreview2() {
    UserInfoField(modifier = Modifier,
        leadingIcon = null,
        enabled = true,
        trailingIcon = RSTheme.icons.icSearch,
        label = stringResource(id = R.string.nickname),
        value = "",
        onValueChange = {},
        onIconCLick = {})
}

@Preview(showBackground = true)
@Composable
fun UserInfoFieldPreview1() {
    UserInfoField(modifier = Modifier,
        leadingIcon = null,
        enabled = true,
        trailingIcon = RSTheme.icons.icSearch,
        label = stringResource(id = R.string.nickname),
        value = "",
        fullSize = true,
        hint = "dsdsdsdsd",
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        onValueChange = {},
        onIconCLick = {})
}

