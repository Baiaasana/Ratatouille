package com.example.designsystem.components.fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme

@Composable
fun PriceInputField(
    modifier: Modifier = Modifier,
    priceChange: (Int) -> Unit,
    onSelectCurrency: (String) -> Unit
) {

    var selectedCurrency by remember { mutableStateOf("USD") }
    var price by remember { mutableStateOf("") }

    val currencyIcon = when (selectedCurrency) {
        "EUR" -> RSTheme.icons.icCurrencyEuro
        "GEL" -> RSTheme.icons.icCurrencyLari
        else -> RSTheme.icons.icCurrencyDollar
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = stringResource(id = R.string.max_price),
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
                .padding(end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Text field for entering price
            OutlinedTextField(
                value = price,
                onValueChange = {
                    price = it
                    priceChange.invoke(it.toInt())
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = currencyIcon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = RSTheme.colors.textColorMain,
                    unfocusedTextColor = RSTheme.colors.textColorMain,
                    cursorColor = RSTheme.colors.textColorPrimary,
                    errorTextColor = RSTheme.colors.errorColor,
                    disabledTextColor = RSTheme.colors.outlineInActive,
                    disabledTrailingIconColor = RSTheme.colors.outlineInActive,
                    disabledIndicatorColor = RSTheme.colors.outlineInActive,
                    errorContainerColor = RSTheme.colors.bgColorMain,
                    disabledContainerColor = RSTheme.colors.bgColorMain,
                    focusedContainerColor = RSTheme.colors.bgColorMain,
                    unfocusedContainerColor = RSTheme.colors.bgColorMain,
                    unfocusedTrailingIconColor = RSTheme.colors.greenDark,
                    focusedTrailingIconColor = RSTheme.colors.greenDark
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Dropdown menu for currency selection
            DropdownMenuCurrencySelector(
                selectedCurrency = selectedCurrency,
                onCurrencyChange = {
                    onSelectCurrency(it)
                    selectedCurrency = it
                }
            )
        }
    }


}

@Composable
fun DropdownMenuCurrencySelector(
    selectedCurrency: String,
    onCurrencyChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { expanded = true }

        ) {
            Text(
                text = selectedCurrency,
                modifier = Modifier
                    .padding(8.dp)
            )
            Icon(
                painter = painterResource(id = RSTheme.icons.icDropDown),
                contentDescription = "More Options"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text("USD")
                },
                onClick = {
                    onCurrencyChange("USD")
                    expanded = false
                })
            DropdownMenuItem(onClick = {
                onCurrencyChange("EUR")
                expanded = false
            },
                text = {
                    Text("EUR")
                })
            DropdownMenuItem(onClick = {
                onCurrencyChange("GEL")
                expanded = false
            }, text = {
                Text("GEL")
            })
        }
    }
}
