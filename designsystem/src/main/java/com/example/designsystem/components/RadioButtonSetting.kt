package com.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme
import com.example.domain.model.ThemeModel

@Composable
fun RadioButtonSetting(
    modifier: Modifier = Modifier,
    options: List<ThemeModel>,
    selectedItemId: Int, // Pass selected item id
    onSelect: (Int) -> Unit
) {
    val selectedOption = options.firstOrNull { it.id == selectedItemId }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        options.forEach { setting ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (setting == selectedOption),
                        onClick = {
                            if (setting != selectedOption) {
                                onSelect(setting.id) // Trigger the onSelect callback
                            }
                        }
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                setting.icon?.let {
                    Icon(
                        imageVector = ImageVector.vectorResource(it),
                        contentDescription = null,
                        tint = RSTheme.colors.textColorMain,
                    )
                }

                Text(
                    text = setting.name,
                    color = RSTheme.colors.textColorMain,
                    style = RSTheme.typography.medium16,
                    modifier = Modifier.weight(1f)
                )

                RadioButton(
                    selected = (setting == selectedOption),
                    onClick = {
                        if (setting != selectedOption) {
                            onSelect(setting.id) // Trigger the onSelect callback
                        }
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RSTheme.colors.textColorPrimary,
                        unselectedColor = RSTheme.colors.textColorMain
                    )
                )
            }
        }
    }
}


@Composable
@Preview
fun RadioButtonSettingPreview() {
    val list = listOf(
        ThemeModel(name = "A", id = 1, icon = RSTheme.icons.icSun),
        ThemeModel(name = "B", id = 2, icon = RSTheme.icons.icUser),
        ThemeModel(name = "C", id = 3, icon = RSTheme.icons.icFaq)
    )
    RadioButtonSetting(
        options = list,
        selectedItemId = 0, // Example selected item id
        onSelect = {}
    )
}
