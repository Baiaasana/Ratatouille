package com.example.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.components.fields.UserInfoField
import com.example.designsystem.theme.RSTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderSelector(
    onSelectGender: (String) -> Unit,
    selectedGender: String,
    modifier: Modifier = Modifier
) {
    val genders = arrayOf(
        stringResource(id = com.example.designsystem.R.string.female), stringResource(
            id = com.example.designsystem.R.string.male,
        ), stringResource(
            id = com.example.designsystem.R.string.other,
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

            UserInfoField(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .menuAnchor(),
                enabled = false,
                mustAdd = true,
                label = stringResource(id = R.string.gender),
                value = selectedGender.ifEmpty { genders[0] },
                leadingIcon = RSTheme.icons.icUser,
                onValueChange = { newValue ->
//                    onEvent.invoke(ProfileInfoEvent.ChangeFullName(newValue))
                },
                trailingIcon = RSTheme.icons.icDropDown,
                onIconCLick = {
                    expanded = true
                }
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