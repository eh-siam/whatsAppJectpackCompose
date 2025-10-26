package com.simec.e_planner.ui.features.calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.e_planner.R

/**
 * Created by Emdadul Haque Siam on 17,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun CalenderScreen(navController: NavHostController){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 10.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp, end = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                            text = "Calls",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                )
                Row (
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.photo_camera),
                        contentDescription = "Options Icon",
                        modifier = Modifier
                            .size(24.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.dots),
                        contentDescription = "Options Icon",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
        }

        var searchText by remember { mutableStateOf("") }

        Column (
            modifier = Modifier
                .padding(top = 16.dp)
        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, start = 10.dp, end = 10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text("Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                )
                //Item list
                LazyColumn (
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 5.dp)

                ){
                    items(20) { index ->
                        HomeItem(index + 1)
                    }
                }
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMyScreen() {
    CalenderScreen(navController = NavHostController(LocalContext.current))
}