package com.simec.eventPlanner.ui.features.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.components.EventTypePieChart
import com.simec.eventPlanner.ui.features.home.eventList.EachEventCard
import com.simec.eventPlanner.ui.model.EventType
import com.simec.eventPlanner.ui.model.samplePieData
import com.simec.eventPlanner.ui.theme.NunitoMedium
import java.util.UUID

private val eventList = List(2) { index ->
    EventType(
        id = UUID.randomUUID().toString(),
        type = "Event $index",
        persons = 10,
        date = "2025-11-13",
        time = "10:00 AM",
        location = "Location $index",
        imageUrl = ""
    )
}

@Composable
fun HomeScreen(navController: NavHostController? = null) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.white))
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_1),
                    contentDescription = "Profile Pic",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(0.2.dp, Color.Black, CircleShape)
                        .align(Alignment.CenterStart)
                        .clickable {
                            navController?.navigate("profile")
                        }
                )
                Text(
                    text = "Events Dashboard",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.MainCardColor),
                    modifier = Modifier.align(Alignment.Center)
                )
                Text(
                    text = "Add(+)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.MainCardColor),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable {
                            navController?.navigate("add")
                        }
                )
            }
        }

        item {
            Divider(
                color = colorResource(id = R.color.grey),
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text(
                text = "Monthly Event Overview",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.title),
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box {
                    AsyncImage(
                        model = R.drawable.bg_background_rectangle,
                        contentDescription = "Card design",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            EventStatus("Upcoming Events", "24")
                            EventStatus("Ongoing Events", "12")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            EventStatus("Completed Events", "06")
                            EventStatus("Rejected Events", "02")
                        }
                        Spacer(modifier = Modifier.padding(top = 18.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(R.color.MainCardColor))
                                .padding(vertical = 12.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Total Events : ",
                                fontSize = 13.sp,
                                fontFamily = NunitoMedium,
                                fontWeight = FontWeight.Medium,
                                color = colorResource(id = R.color.myCustomColor)
                            )
                            Text(
                                text = "44",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.myCustomColor)
                            )
                        }
                    }
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 7.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Upcoming Event",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.title)
                )
                Text(
                    text = "View All",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.MainCardColor)
                )
            }
        }

        items(eventList.size) { index ->
            EachEventCard(event = eventList[index])
        }

        item {
            Text(
                text = "Event Type Pie Chart",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.title),
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp, bottom = 10.dp)
            ) {
                EventTypePieChart(data = samplePieData)
            }
        }
    }
}

@Composable
fun EventStatus(title: String, count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 13.sp,
            fontFamily = NunitoMedium,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.CardTextColor)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = count,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.CardTextColor)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}
