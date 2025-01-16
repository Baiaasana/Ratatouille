package com.example.designsystem.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagInputField(
    label: Int,
    hint: Int,
    modifier: Modifier = Modifier,
    selectedTags: List<String>,
    onTagRemoved: (String) -> Unit,
    dropDownClick: () -> Unit,
) {

    Column(modifier = modifier) {

        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = stringResource(id = label),
            style = RSTheme.typography.medium14,
            color = RSTheme.colors.textColorMain
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = RSTheme.colors.profileFieldBorder,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FlowRow(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (selectedTags.isEmpty()) {
                    Text(
                        text = stringResource(id = hint),
                        style = RSTheme.typography.regular12,
                        color = RSTheme.colors.textColorMain
                    )
                }
                selectedTags.forEach { tag ->
                    TagChip(tag = tag, onRemoveClick = { onTagRemoved(tag) })
                }
            }
            IconButton(
                onClick = {
                    dropDownClick()
                }) {
                Icon(
                    painter = painterResource(id = RSTheme.icons.icDropDown),
                    contentDescription = "Dropdown"
                )
            }
        }
    }
}

@Composable
fun TagChip(tag: String, onRemoveClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(RSTheme.colors.bgGray, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp)
            .padding(start = 16.dp, end = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = tag,
                color = RSTheme.colors.textColorMain,
                style = RSTheme.typography.regular12,
            )
            IconButton(
                onClick = onRemoveClick,
                modifier = Modifier.size(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = RSTheme.icons.icClose),
                    contentDescription = "Remove Tag",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TagInputFieldPreview() {
    var selectedTags by remember { mutableStateOf(listOf<String>()) }

    TagInputField(
        selectedTags = selectedTags,
        onTagRemoved = { tag ->
            selectedTags = selectedTags - tag
        },
        label = R.string.tags,
        hint = R.string.enter_tags,
        dropDownClick = {}
    )
}


@Preview(showBackground = true)
@Composable
fun TagChipPreview() {

    TagChip(
        tag = "dsds", {}
    )
}
