package com.simec.eventPlanner.ui.features.home.eventList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.model.EventType
import com.simec.eventPlanner.ui.theme.NunitoMedium
import com.simec.eventPlanner.ui.theme.NunitoSemiBold

/**
 * Created by Emdadul Haque Siam on 28,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EachEventCard(event: EventType) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Event Image
            AsyncImage(
                model = event.imageUrl,
                contentDescription = "Event Image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.bg_background_rectangle),
                error = painterResource(R.drawable.bg_background_rectangle),
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Event Info - The redundant and expensive `weight` modifier is removed.
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                EventInfoRow("Type:", event.type)
                EventInfoRow("Persons:", event.persons.toString())
                EventInfoRow("Date:", event.date)
                EventInfoRow("Time:", event.time)
                EventInfoRow("Location:", event.location)
            }
        }
    }
}

@Composable
private fun EventInfoRow(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontFamily = NunitoMedium,
            color = colorResource(id = R.color.level),
            modifier = Modifier.width(70.dp)
        )
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = NunitoSemiBold,
            color = colorResource(id = R.color.result),
            maxLines = 2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEachEventCard() {
    EachEventCard(
        event = EventType(
            id = "",
            type = "Social Event",
            persons = 120,
            date = "09-10-25",
            time = "02:30 PM",
            location = "127, Sector 12, Uttara, Dhaka-1230, Bangladesh",
            imageUrl = ""
        )
    )
}