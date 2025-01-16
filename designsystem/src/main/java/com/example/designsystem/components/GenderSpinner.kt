package com.example.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.RSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderSpinner(
    onSelectGender: (String) -> Unit,
    selectedGender: String,
    modifier: Modifier = Modifier
) {
    val genders = arrayOf(
        stringResource(id = com.example.designsystem.R.string.female), stringResource(
            id = com.example.designsystem.R.string.male
        )
    )
    var expanded by remember { mutableStateOf(false) }
//    var selectedText by remember { mutableStateOf(genders[0]) }

    Box(
        modifier = modifier
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedGender.ifEmpty { genders[0] },
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(
                        text = stringResource(id = com.example.designsystem.R.string.gender),
                        style = RSTheme.typography.regular14
                    )
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                colors = TextFieldDefaults.colors(
                    disabledTextColor = RSTheme.colors.textColorMain,
                    disabledIndicatorColor = RSTheme.colors.outlineInActive,
                    unfocusedIndicatorColor = RSTheme.colors.outlineInActive,
                    focusedIndicatorColor = RSTheme.colors.outlineInActive,
                    disabledTrailingIconColor = RSTheme.colors.outlineInActive,
                    focusedTextColor = RSTheme.colors.textColorMain,
                    unfocusedTextColor = RSTheme.colors.textColorMain,
                    unfocusedLabelColor = RSTheme.colors.textColorMain,
                    cursorColor = RSTheme.colors.textColorPrimary,
                    focusedLabelColor = RSTheme.colors.textColorMain,
                    errorLabelColor = RSTheme.colors.errorColor,
                    unfocusedContainerColor = RSTheme.colors.bgColorMain,
                    focusedContainerColor = RSTheme.colors.bgColorMain,
                    errorContainerColor = RSTheme.colors.buttonTextMain,
                    disabledContainerColor = RSTheme.colors.buttonTextMain,
                    unfocusedTrailingIconColor = RSTheme.colors.textColorMain,
                ),
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                genders.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            onSelectGender(item)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DropdownPreview() {

}
