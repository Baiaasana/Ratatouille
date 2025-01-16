package com.example.designsystem.components.modal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.components.fields.MyTextField
import com.example.designsystem.theme.RSTheme
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWithCallback(
    list: ArrayList<String>,
    selectedValue: String,
    onDismiss: (String) -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val searchText = rememberSaveable { mutableStateOf("") }
    val selectedCountry = rememberSaveable { mutableStateOf(selectedValue) }
    val countries = remember { mutableStateOf(list) }
    var filteredCountries: ArrayList<String>

    val paddingModifier = if (modalBottomSheetState.currentValue == SheetValue.Expanded) {
        Modifier.padding(bottom = 0.dp) // Remove bottom padding when expanded
    } else {
        Modifier.padding(bottom = 16.dp) // Set default bottom padding
    }
    ModalBottomSheet(
        onDismissRequest = { onDismiss(selectedCountry.value) },
        sheetState = modalBottomSheetState,
        contentColor = RSTheme.colors.textColorPrimary,
        containerColor = RSTheme.colors.bgColorMain,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column {
            MyTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                label = stringResource(id = R.string.search),
                textFieldValue = searchText.value,
                onValueChange = {
                    searchText.value = it
                },
                withIcon = false,
            )
        }

        Spacer(modifier = Modifier.height(6.dp))
        LazyColumn(
            Modifier
                .padding(top = 8.dp)
                .height(350.dp)
                .then(paddingModifier)
        ) {
            filteredCountries = if (searchText.value.isEmpty()) {
                countries.value
            } else {
                val resultList = ArrayList<String>()
                for (country in countries.value) {
                    if (country.lowercase(Locale.getDefault())
                            .contains(searchText.value.lowercase(Locale.getDefault()))
                    ) {
                        resultList.add(country)
                    }
                }
                resultList
            }
            items(filteredCountries, itemContent = { item ->
                Text(
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                        .clickable {
                            searchText.value = item
                            selectedCountry.value = item
                            onDismiss(selectedCountry.value)
                        }, text = item,
                    color = RSTheme.colors.textColorMain,
                    style = RSTheme.typography.regular14
                )
            })
        }
    }
}