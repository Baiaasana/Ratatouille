package com.example.designsystem.components.modal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.RSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModal(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        contentColor = RSTheme.colors.textColorPrimary,
        containerColor = RSTheme.colors.bgColorMain,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .imePadding() // Moves modal content up when keyboard appears
                .navigationBarsPadding() // Kee
        ) {
            content()
        }
    }
}
