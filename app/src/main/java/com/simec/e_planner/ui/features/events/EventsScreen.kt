package com.simec.e_planner.ui.features.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.e_planner.ui.features.home.eventList.EachEventCard

/**
 * Created by Emdadul Haque Siam on 23,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EventsScreen(navController: NavHostController) {

    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        ){

            Text(
                text = "All Events",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Center)
            )

        }

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        LazyColumn (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ){
            items(20){index ->
                EachEventCard(index+1)
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    EventsScreen(navController = NavHostController(LocalContext.current))
}