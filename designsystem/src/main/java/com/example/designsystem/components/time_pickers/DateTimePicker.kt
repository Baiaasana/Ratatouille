package com.example.designsystem.components.time_pickers

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.fields.UserInfoField
import com.example.designsystem.theme.RSTheme
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

// Data class to hold the formatted dates
data class FormattedDates(
    val startDate: String,
    val endDate: String
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateTimePicker(
    label: String,
    selectedDateTime: LocalDateTime,
    onDateTimeSelected: (LocalDateTime) -> Unit,
    displayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
) {
    val context = LocalContext.current
    var dateTime by remember { mutableStateOf(selectedDateTime) }

    UserInfoField(
        modifier = Modifier.padding(top = 16.dp),
        mustAdd = false,
        enabled = true,
        trailingIcon = RSTheme.icons.icCalendar,
        label = label,
        value = dateTime.format(displayFormatter),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        onValueChange = {},
        onIconCLick = {
            DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    TimePickerDialog(
                        context,
                        { _, hourOfDay, minute ->
                            dateTime = LocalDateTime.of(
                                year, month + 1, dayOfMonth,
                                hourOfDay, minute, 0
                            )
                            onDateTimeSelected(dateTime)
                        },
                        dateTime.hour,
                        dateTime.minute,
                        true
                    ).show()
                },
                dateTime.year,
                dateTime.monthValue - 1,
                dateTime.dayOfMonth
            ).show()
        }

    )
}

// Utility functions for ISO-8601 formatting
@RequiresApi(Build.VERSION_CODES.O)
fun getIsoFormatter(): DateTimeFormatter {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
        .withZone(ZoneOffset.UTC)
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatToIsoString(localDateTime: LocalDateTime): String {
    // Convert LocalDateTime to UTC and format
    return localDateTime
        .atZone(ZoneId.systemDefault())
        .withZoneSameInstant(ZoneOffset.UTC)
        .format(getIsoFormatter())
}

// Extension function to convert formatted dates to JSON format
fun FormattedDates.toJson(): String {
    return """
        {
            "start_date": "$startDate",
            "end_date": "$endDate"
        }
    """.trimIndent()
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun DateTimePickerPreview() {
    DateTimePicker(
        label = "Start date",
        selectedDateTime = LocalDateTime.now(),
        onDateTimeSelected = { },
    )
}


//// Data class to hold the formatted dates
//data class FormattedDates(
//    val startDate: String,
//    val endDate: String
//)

//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DateTimePicker(
//    label: String,
//    selectedDateTime: LocalDateTime,
//    onDateTimeSelected: (LocalDateTime) -> Unit,
//    displayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")
//) {
//    val context = LocalContext.current
//    var dateTime by remember { mutableStateOf(selectedDateTime) }
//
//    OutlinedCard(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable {
//                DatePickerDialog(
//                    context,
//                    { _, year, month, dayOfMonth ->
//                        TimePickerDialog(
//                            context,
//                            { _, hourOfDay, minute ->
//                                dateTime = LocalDateTime.of(
//                                    year, month + 1, dayOfMonth,
//                                    hourOfDay, minute, 0
//                                )
//                                onDateTimeSelected(dateTime)
//                            },
//                            dateTime.hour,
//                            dateTime.minute,
//                            true
//                        ).show()
//                    },
//                    dateTime.year,
//                    dateTime.monthValue - 1,
//                    dateTime.dayOfMonth
//                ).show()
//            }
//            .padding(8.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column {
//                Text(
//                    text = label,
//                    style = MaterialTheme.typography.bodyMedium,
//                    color = MaterialTheme.colorScheme.onSurfaceVariant
//                )
//                Text(
//                    text = dateTime.format(displayFormatter),
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//            Icon(
//                painter = painterResource(id = RSTheme.icons.icCalendar),
//                contentDescription = "Select date and time",
//                tint = MaterialTheme.colorScheme.primary
//            )
//        }
//    }
//}
//
//// Utility functions for ISO-8601 formatting
//@RequiresApi(Build.VERSION_CODES.O)
//fun getIsoFormatter(): DateTimeFormatter {
//    return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
//        .withZone(ZoneOffset.UTC)
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun formatToIsoString(localDateTime: LocalDateTime): String {
//    // Convert LocalDateTime to UTC and format
//    return localDateTime
//        .atZone(ZoneId.systemDefault())
//        .withZoneSameInstant(ZoneOffset.UTC)
//        .format(getIsoFormatter())
//}
//
//// Extension function to convert formatted dates to JSON format
//fun FormattedDates.toJson(): String {
//    return """
//        {
//            "start_date": "$startDate",
//            "end_date": "$endDate"
//        }
//    """.trimIndent()
//}


