package com.example.designsystem.components.alert

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.components.CustomButton
import com.example.designsystem.components.DefaultButton
import com.example.designsystem.theme.RSTheme

@Composable
fun CustomAlert(
    onCancelRequest: (() -> Unit) = {},
    onDismissRequest: () -> Unit,
    onConfirmation: (() -> Unit) = {}, // Make onConfirmation nullable
    hasDouble: Boolean = false,
    confirmButtonText: String = "",
    alertType: AlertType? = null,
    dialogTitle: String? = null,
    dialogText: String,
    buttonText: String,
) {
    AlertDialog(
        modifier = Modifier
            .background(
                color = RSTheme.colors.bgColorMain,
                shape = RoundedCornerShape(8)
            ),
        containerColor = RSTheme.colors.bgColorMain,
        textContentColor = RSTheme.colors.textColorMain,
        titleContentColor = RSTheme.colors.textColorMain,
        title = dialogTitle?.let {
            {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dialogTitle,
                    style = RSTheme.typography.bold16,
                    textAlign = TextAlign.Center
                )
            }
        },
        icon = alertType?.let {
            {
                when (alertType) {
                    AlertType.SUCCESS -> Image(
                        painter = painterResource(id = RSTheme.icons.icSuccess),
                        contentDescription = "null"
                    )

                    AlertType.ERROR -> Image(
                        painter = painterResource(id = RSTheme.icons.icError),
                        contentDescription = "null"
                    )

                    AlertType.WARNING -> Image(
                        painter = painterResource(id = RSTheme.icons.icError),
                        contentDescription = "null"
                    )
                }
            }
        },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = dialogText,
                style = RSTheme.typography.regular14,
                textAlign = TextAlign.Center
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            if (hasDouble) {
                CustomButton(
                    text = confirmButtonText,
                    onClick = {
                        onConfirmation()
                    }
                )
            } else {
                null
            }
        },
        dismissButton = {
            if (hasDouble) {
                CustomButton(
                    isOutlined = true,
                    text = buttonText,
                    onClick = {
                        onCancelRequest()
                    }
                )
            } else {
                DefaultButton(
                    text = buttonText,
                    onClick = {
                        onDismissRequest()
                    }
                )
            }
        }
    )
}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AlertPreview() {
    CustomAlert(
        onConfirmation = {},
        onDismissRequest = {},
        onCancelRequest = {},
        dialogTitle = "title",
        dialogText = "text",
        buttonText = "Ok"
    )
}


@Preview(showBackground = true)
@Composable
fun AlertPreview2() {
    CustomAlert(
        onConfirmation = {},
        onDismissRequest = {},
        onCancelRequest = {},
        dialogTitle = null,
        dialogText = "text",
        buttonText = "Ok"
    )
}

@Preview(showBackground = true)
@Composable
fun AlertDoublePreview() {
    CustomAlert(
        onConfirmation = {},
        onDismissRequest = {},
        onCancelRequest = {},
        confirmButtonText = "confirm",
        hasDouble = true,
        dialogTitle = "title",
        dialogText = "text",
        buttonText = "Cancel"
    )
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExamplePreview() {
    AlertDialogExample(onDismissRequest = {}, onConfirmation = {}, "title", "text")


}