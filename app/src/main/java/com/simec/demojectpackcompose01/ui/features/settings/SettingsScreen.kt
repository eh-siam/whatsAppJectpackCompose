package com.simec.demojectpackcompose01.ui.features.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.R

/**
 * Created by Emdadul Haque Siam on 17,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun SettingsScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp)
        ) {

            Text(
                text = "Settings",
                fontSize = 18.sp,
                fontWeight = Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }


        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            //Event Preferences
            Card(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("event")
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Event Preferences",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp),


                        )

                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 10.dp)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("payments")
                }
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Payments & Billing",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp)

                    )


                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 10.dp)
                    )


                }

            }
            //App Preferences
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("app_preference")
                }
                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "App Preferences",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp),

                        )

                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 10.dp)
                    )

                }

            }

            //Rewards & Membership
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("rewards")
                }
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Rewards & Membership",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .padding(end = 10.dp)

                    )
                }

            }

            //Support & Help
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("support")
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Support & Help",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)

                    )
                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 16.dp)
                    )
                }
            }


            //Organizer Tools
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("organizer")
                }
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Organizer Tools",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)

                    )

                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 10.dp)
                    )
                }
            }
            //Account Actions
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    navController.navigate("account_actions")
                }
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Account Actions",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp)

                    )

                    Image(
                        painter = painterResource(R.drawable.arrow__11_),
                        contentDescription = "Arrow ",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = NavHostController(LocalContext.current))
}


