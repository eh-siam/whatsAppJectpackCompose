package com.simec.eventPlanner.ui.components

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
import com.simec.eventPlanner.ui.model.MonthlyIncome
import com.simec.eventPlanner.ui.model.sampleMonthlyIncome

@Composable
fun MonthlyIncomeBarChart(
    data: List<MonthlyIncome>,
    modifier: Modifier = Modifier,
    mainCardColor: Color = Color(0xFF054456), // 🔵 Your main color
    axisColor: Color = Color.Gray,
    labelColor: Color = Color.Black,
    maxChartHeight: Dp = 200.dp,
    labelHeight: Dp = 20.dp
) {
    val maxIncome = data.maxOfOrNull { it.income } ?: 0f
    val ySteps = 5
    val scrollState = rememberScrollState()
    val barWidthDp = 40.dp
    val spacingDp = 20.dp
    val density = LocalDensity.current

    Column(modifier = modifier.padding(5.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
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

            Box(modifier = Modifier.horizontalScroll(scrollState)) {
                Canvas(
                    modifier = Modifier
                        .height(maxChartHeight + labelHeight)
                        .width(data.size * (barWidthDp + spacingDp))
                ) {
                    val canvasHeight = size.height - with(density) { labelHeight.toPx() }
                    val barWidth = with(density) { barWidthDp.toPx() }
                    val spacing = with(density) { spacingDp.toPx() }

                    data.forEachIndexed { index, item ->
                        val barHeight = if (maxIncome == 0f) 0f else (item.income / maxIncome) * canvasHeight

                        // 🎨 Color logic
                        val currentColor = when {
                            item.income < 3800f -> Color(0xFFD32F2F)  //Danger Zone
                            item.income < 7600f -> Color(0xB3054456)  //Average Zone (Soft Orange)
                            else -> mainCardColor                   // High Performance Zone (Your color)
                        }

                        drawRect(
                            color = currentColor,
                            topLeft = Offset(
                                x = index * (barWidth + spacing),
                                y = canvasHeight - barHeight
                            ),
                            size = androidx.compose.ui.geometry.Size(barWidth, barHeight)
                        )
                    }

                    drawLine(axisColor, start = Offset(0f, 0f), end = Offset(0f, canvasHeight), strokeWidth = 2f)
                    drawLine(axisColor, start = Offset(0f, canvasHeight), end = Offset(size.width, canvasHeight), strokeWidth = 2f)
                }
            }
        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(top = 4.dp, start = 30.dp)
        ) {
            data.forEach { item ->
                Box(
                    modifier = Modifier.width(barWidthDp + spacingDp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    BasicText(
                        text = item.month,
                        style = TextStyle(color = labelColor, fontSize = 12.sp)
                    )
                }
            }
        }

        // Optional: Add a color legend below chart
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LegendItem(color = Color(0xFFD32F2F), label = "Low (<3800)")
            LegendItem(color = Color(0xB3054456), label = "Average (3800–7599)")
            LegendItem(color = mainCardColor, label = "High (≥7600)")
        }
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .padding(end = 4.dp)
                .padding(2.dp)
                .let { it.then(Modifier) },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(12.dp)) {
                drawRect(color = color)
            }
        }
        BasicText(
            text = label,
            style = TextStyle(color = Color.Black, fontSize = 10.sp)
        )
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


