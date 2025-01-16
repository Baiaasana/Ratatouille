package com.example.designsystem.components.fields.custom

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.components.fields.UserInfoField
import com.example.designsystem.components.modal.BottomSheetWithCallback
import com.example.designsystem.theme.RSTheme

@Composable
fun CustomFieldItem(
    modifier: Modifier,
    field: CustomFieldData,
    onRemove: () -> Unit,
    updateFieldName: (String) -> Unit,
    updateFieldValue: (String) -> Unit,
) {
    Log.d("continueClick", "recompose $field")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        var expanded by remember { mutableStateOf(false) }

        UserInfoField(modifier = modifier.padding(top = 16.dp),
            hint = stringResource(id = R.string.select_who_can_bid),
            label = "Field name",
            enabled = true,
            value = field.name,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onValueChange = {
                Log.d("continueClick", "onValueChange in $it $field")
//                field.name = it
                updateFieldName.invoke(it)
            },
            onIconCLick = {})

        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 12.dp)
                .clickable { expanded = true },
            text = stringResource(id = R.string.choose_from_the_list),
            style = RSTheme.typography.regular14,
            color = RSTheme.colors.textColorMain
        )

        UserInfoField(modifier = Modifier,
            hint = stringResource(id = R.string.select_who_can_bid),
            label = "Field value",
            value = field.value,
            enabled = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onValueChange = {
//                field.value = it
                updateFieldValue.invoke(it)
            },
            onIconCLick = {})

        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 12.dp)
                .clickable { onRemove() },
            text = stringResource(id = R.string.remove),
            style = RSTheme.typography.regular14,
            color = RSTheme.colors.textColorMain
        )

        if (expanded) {
            BottomSheetWithCallback(
                list = arrayListOf(
                    stringResource(id = R.string.new_word),
                    stringResource(id = R.string.used_like_new),
                    stringResource(id = R.string.used_very_good),
                    stringResource(id = R.string.used_good),
                    stringResource(id = R.string.used_acceptable),
                ),
                selectedValue = field.name,
                onDismiss = {
                    Log.d("showConditionList", "it $it ${field.name}")
                    expanded = false
                    field.name = it
                },
            )
        }
    }
}

@Composable
@Preview
fun customPreview() {
    CustomFieldItem(
        modifier = Modifier,
        CustomFieldData(name = "name", value = "valll"),
        onRemove = {},
        updateFieldValue = {},
        updateFieldName = {},
    )
}
