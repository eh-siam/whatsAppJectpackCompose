package com.simec.e_planner.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.simec.e_planner.ui.model.MonthlyIncome
import com.simec.e_planner.ui.model.sampleMonthlyIncome

@Composable
fun MonthlyIncomeBarChart(
    data: List<MonthlyIncome>,
    modifier: Modifier = Modifier,
    barColor: Color = Color(0xFF1565C0),
    axisColor: Color = Color.Gray,
    labelColor: Color = Color.Black,
    maxChartHeight: Dp = 200.dp,
    labelHeight: Dp = 20.dp // month label er jonno
) {
    val maxIncome = data.maxOfOrNull { it.income } ?: 0f
    val ySteps = 5
    val scrollState = rememberScrollState()
    val barWidthDp = 40.dp
    val spacingDp = 20.dp

    val density = LocalDensity.current

    Column(modifier = modifier.padding(5.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            // Y-axis labels
            Column(
                modifier = Modifier.height(maxChartHeight),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                for (i in ySteps downTo 0) {
                    BasicText(
                        text = "${(maxIncome / ySteps * i).toInt()} tk",
                        style = TextStyle(color = labelColor, fontSize = 10.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Scrollable bar chart
            Box(modifier = Modifier.horizontalScroll(scrollState)) {
                Canvas(
                    modifier = Modifier
                        .height(maxChartHeight + labelHeight) // label er jonno extra space
                        .width(data.size * (barWidthDp + spacingDp))
                ) {
                    val canvasHeight = size.height - with(density) { labelHeight.toPx() } // bar height er jonno
                    val barWidth = with(density) { barWidthDp.toPx() }
                    val spacing = with(density) { spacingDp.toPx() }

                    data.forEachIndexed { index, item ->
                        val barHeight = if (maxIncome == 0f) 0f else (item.income / maxIncome) * canvasHeight
                        drawRect(
                            color = barColor,
                            topLeft = Offset(
                                x = index * (barWidth + spacing),
                                y = canvasHeight - barHeight // bar er top
                            ),
                            size = androidx.compose.ui.geometry.Size(barWidth, barHeight)
                        )
                    }

                    // Y-axis
                    drawLine(axisColor, start = Offset(0f, 0f), end = Offset(0f, canvasHeight), strokeWidth = 2f)
                    // X-axis
                    drawLine(axisColor, start = Offset(0f, canvasHeight), end = Offset(size.width, canvasHeight), strokeWidth = 2f)
                }
            }
        }

        // X-axis labels under bar
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(top = 4.dp, start = 30.dp)
        ) {
            data.forEach { item ->
                Box(
                    modifier = Modifier
                        .width(barWidthDp + spacingDp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    BasicText(
                        text = item.month,
                        style = TextStyle(color = labelColor, fontSize = 12.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 300)
@Composable
fun MonthlyIncomeBarChartPreview() {
    MonthlyIncomeBarChart(
        data = sampleMonthlyIncome,
        maxChartHeight = 220.dp
    )
}


