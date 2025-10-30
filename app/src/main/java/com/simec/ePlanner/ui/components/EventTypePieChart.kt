package com.simec.ePlanner.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simec.ePlanner.ui.model.EventTypeData
import com.simec.ePlanner.ui.model.samplePieData
import com.simec.ePlanner.R

@Composable
fun EventTypePieChart(
    data: List<EventTypeData>,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 40.dp
) {
    val totalCount = data.sumOf { it.count.toDouble() }.toFloat()

    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // --- Pie Chart Section ---
        Box(
            modifier = Modifier.size(140.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                var startAngle = -90f
                data.forEach { item ->
                    val sweepAngle =
                        if (totalCount == 0f) 0f else (item.count / totalCount) * 360f
                    drawArc(
                        color = item.color,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(width = strokeWidth.toPx())
                    )
                    startAngle += sweepAngle
                }
            }

            // Center text (Total events)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Total Events",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.MainCardColor)
                    )
                )
                Text(
                    text = totalCount.toInt().toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
            }
        }

        Spacer(modifier = Modifier.width(40.dp))

        // --- Legend Section ---
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            data.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(color = item.color, shape = RoundedCornerShape(4.dp))
                    )
                    Text(
                        text = "${item.type} — ${item.count}",
                        style = TextStyle(fontSize = 14.sp, color = Color.DarkGray)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 240)
@Composable
fun EventTypePieChartPreview() {
    EventTypePieChart(
        data = samplePieData
    )
}
