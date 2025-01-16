package com.example.designsystem.components

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.R
import com.example.designsystem.theme.RSTheme
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.GridProperties
import ir.ehsannarmani.compose_charts.models.Line

// Define your month names for X-axis labels
val monthNames =
    listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

@Composable
fun LineChartWithXAxis() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .width(600.dp)
            .padding(top = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {
            val gridProperties = GridProperties(
                enabled = false,
                xAxisProperties = GridProperties.AxisProperties(enabled = false
                ),
                yAxisProperties = GridProperties.AxisProperties(
                    enabled = false
                )
            )

            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), // Fixed height instead of weight
                gridProperties = gridProperties,
                data = listOf(
                    Line(
                        label = stringResource(id = R.string.buyer),
                        values = listOf(28.0, 41.0, 5.0, 10.0, 35.0),
                        color = SolidColor(RSTheme.colors.textColorPrimary),
                        firstGradientFillColor = RSTheme.colors.textColorPrimary.copy(alpha = .3f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                        gradientAnimationDelay = 1000,
                        drawStyle = DrawStyle.Stroke(width = 2.dp),
                    ),

                    Line(
                        label = stringResource(id = R.string.seller),
                        values = listOf(18.0, 35.0, 30.0, 25.0, 27.0),
                        color = SolidColor(RSTheme.colors.green),
                        firstGradientFillColor = RSTheme.colors.green.copy(alpha = .3f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                        gradientAnimationDelay = 1000,
                        drawStyle = DrawStyle.Stroke(width = 2.dp),
                    )
                ),
                animationMode = AnimationMode.Together(delayBuilder = { it * 500L }),
            )

            // X-axis with month labels
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                monthNames.forEach { month ->
                    Text(
                        text = month,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }


}


@Preview
@Composable
fun LineChartPreview() {
    LineChartWithXAxis()
}