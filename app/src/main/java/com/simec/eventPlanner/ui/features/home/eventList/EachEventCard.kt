package com.simec.eventPlanner.ui.features.home.eventList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.model.EventType
import com.simec.eventPlanner.ui.theme.NunitoMedium
import com.simec.eventPlanner.ui.theme.NunitoSemiBold

/**
 * Created by Emdadul Haque Siam on 28,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

// Data model for dynamic event info
@Composable
fun EachEventCard(event: EventType) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 2.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(0.6.dp, colorResource(id = R.color.grey))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Event Image
            Card(
                modifier = Modifier
                    .size(120.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(event.imageUrl)
                        .crossfade(true)
                        .placeholder(R.drawable.bg_background_rectangle)
                        .error(R.drawable.bg_background_rectangle)
                        .memoryCacheKey(event.imageUrl)  // caching key
                        .diskCachePolicy(coil.request.CachePolicy.ENABLED)
                        .build(),
                    contentDescription = "Event Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Event Info
            Column(
                modifier = Modifier.weight(1f),
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
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEachEventCard() {
    EachEventCard(
        event = EventType(
            type = "Social Event",
            persons = 120,
            date = "09-10-25",
            time = "02:30 PM",
            location = "127, Sector 12, Uttara",
            imageUrl = "https://picsum.photos/300/200" // Sample image
        )
    )
}
