package com.simec.e_planner.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.drawscope.Stroke
import com.simec.e_planner.ui.model.EventTypeData


@Composable
fun EventTypePieChart(
    data: List<EventTypeData>,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 40.dp
) {
    val totalIncome = data.sumOf { it.income.toDouble() }.toFloat()
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            var startAngle = -90f
            val radius = size.minDimension / 2

            data.forEach { item ->
                val sweepAngle = if (totalIncome == 0f) 0f else (item.income / totalIncome) * 360f
                drawArc(
                    color = item.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(
                        width = strokeWidth.toPx()
                    )
                )
                startAngle += sweepAngle
            }
        }

        // Center text (total income)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Total",
                style = androidx.compose.ui.text.TextStyle(fontSize = 14.sp, color = Color.Gray)
            )
            Text(
                text = "${totalIncome.toInt()} tk",
                style = androidx.compose.ui.text.TextStyle(fontSize = 18.sp, color = Color.Black)
            )
        }
    }
}
