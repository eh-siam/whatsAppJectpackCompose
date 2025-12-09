package com.simec.eventPlanner.ui.features.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.theme.NunitoMedium

@Composable
fun NotificationScreen(navController: NavHostController) {

    var searchText by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {

            // 🔹 Title
            Text(
                text = "Notification",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )

            // 🔹 Search Field
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                placeholder = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp)
            )

            // 🔹 Filter Chips Bar (THIS WAS MISSING)
            NotificationFilterBar(
                modifier = Modifier.padding(top = 16.dp)
            )

            // 🔹 Notification List Placeholder
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No Notifications Yet")
            }
        }
    }
}

@Composable
fun NotificationFilterBar(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf("All") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        FilterChipItem(
            text = "All",
            count = 24,
            isSelected = selected == "All",
            onClick = { selected = "All" }
        )

        Spacer(modifier = Modifier.width(10.dp))

        FilterChipItem(
            text = "Unread",
            count = 15,
            isSelected = selected == "Unread",
            onClick = { selected = "Unread" }
        )

        Spacer(modifier = Modifier.width(60.dp))

        Text(
            text = "Mark All As Read",
            fontSize = 12.sp,
            fontFamily = NunitoMedium,
            color = colorResource(id = R.color.CardTextColor)
        )
    }
}

@Composable
fun FilterChipItem(
    text: String,
    count: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClick()
        },
        shape = RoundedCornerShape(50),
        color = if (isSelected) Color(0xFF054456) else Color(0x33054456)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = if (isSelected) Color.White else Color.Black,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.width(6.dp))

            Surface(
                shape = CircleShape,
                color = if (isSelected) Color.White else Color(0xFF054456)
            ) {
                Text(
                    text = count.toString(),
                    modifier = Modifier
                        .padding(
                            horizontal = 6.dp,
                            vertical = 2.dp),
                    fontSize = 11.sp,
                    color = if (isSelected) Color(0xFF3B82F6) else Color.White
                )
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNotificationScreen() {
    NotificationScreen(navController = NavHostController(LocalContext.current))
}
