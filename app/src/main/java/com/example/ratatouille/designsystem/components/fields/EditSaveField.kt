package com.example.designsystem.components.fields

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme
import com.example.ratatouille.R

@Composable
fun EditableField(
    modifier: Modifier = Modifier,
    leadingIcon: Int? = null,
    label: String,
    value: String?,
    onValueChange: (String) -> Unit,
    onSave: (String) -> Unit,
    onCancel: () -> Unit,
) {
    var isEditing by remember { mutableStateOf(false) }
    var tempValue by remember { mutableStateOf(value ?: "") }
    val hasTextChanged by remember {
        derivedStateOf {
            tempValue != (value ?: "")
        }
    }

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(value) {
        tempValue = value ?: ""
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = label,
            style = RSTheme.typography.medium14,
            color = RSTheme.colors.textColorMain
        )

        Row(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = RSTheme.colors.profileFieldBorder,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(end = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequester)  // Assign FocusRequester
                    .onFocusChanged {
                        Log.d("onFocusChanged", "onFocusChanged")
                    },

                value = tempValue,
                leadingIcon = leadingIcon?.let { id ->
                    {
                        Icon(
                            painter = painterResource(id = id),
                            contentDescription = null
                        )
                    }
                },
                placeholder = {
                    if (tempValue.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.please_add).plus(
                                " "
                            ).plus(label),
                            style = RSTheme.typography.regular12,
                            color = RSTheme.colors.textColorMain
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    unfocusedTextColor = RSTheme.colors.textColorMain,
                    focusedTextColor = RSTheme.colors.textColorMain,
                    disabledLeadingIconColor = RSTheme.colors.textColorMain,
                    focusedLeadingIconColor = RSTheme.colors.textColorMain,
                    unfocusedLeadingIconColor = RSTheme.colors.textColorMain,
                    cursorColor = RSTheme.colors.textColorPrimary,
                    disabledTextColor = RSTheme.colors.textColorMain,
                ),
                enabled = isEditing,
                onValueChange = {
                    tempValue = it
                    onValueChange(it)
                },
                textStyle = RSTheme.typography.regular12,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (isEditing && hasTextChanged) {
                            onSave(tempValue)
                            isEditing = false // Exit edit mode after saving
                        }
                    }
                )
            )

            Box(
                Modifier
                    .width(56.dp)
                    .height(32.dp)
                    .align(Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(
                        color = if (isEditing && !hasTextChanged) {
                            RSTheme.colors.textColorPrimary.copy(alpha = 0.3f)
                        } else RSTheme.colors.textColorPrimary
                    )
                    .clickable {
                        if (isEditing) {
                            if (hasTextChanged) {
                                onSave(tempValue) // Call save only if text has changed
                            }
                        } else {
                            focusRequester.requestFocus()
                            isEditing = true // Switch to edit mode
                        }
                    },
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = if (isEditing) "Save" else "Edit",
                    color = RSTheme.colors.buttonTextMain,
                    style = RSTheme.typography.regular14,
                    // Disable the button if not editing or if text has not changed
                )
            }

            if (isEditing) {
                Row(
                    Modifier
                        .height(32.dp)
                        .align(Alignment.CenterVertically)
                        .clip(shape = RoundedCornerShape(8.dp))
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable {
                                isEditing = false  // Exit edit mode
                                tempValue = value ?: ""  // Revert changes
                                onCancel()  // Invoke cancel lambda
                            },
                        tint = RSTheme.colors.textColorMain,
                        painter = painterResource(id = RSTheme.icons.icClose),
                        contentDescription = "Cancel",
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserInfoFieldPreview() {
    EditableField(
        modifier = Modifier,
        leadingIcon = RSTheme.icons.icMail,
        label = stringResource(id = R.string.nickname),
        value = "John Doe",
        onValueChange = {},
        onSave = { /* Handle save */ },
        onCancel = { /* Handle cancel */ }
    )
}
