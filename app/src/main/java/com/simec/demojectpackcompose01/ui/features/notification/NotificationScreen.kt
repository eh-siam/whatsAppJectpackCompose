package com.simec.demojectpackcompose01.ui.features.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.R
import com.simec.demojectpackcompose01.ui.features.home.HomeScreen

/**
 * Created by Emdadul Haque Siam on 23,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun NotificationScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Image(
                painter = painterResource(id = R.drawable.arrow_blue),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 10.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterStart)
            )

            Text(
                text = "Notification",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Center)
            )

            Image(
                painter = painterResource(id = R.drawable.messenger),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 10.dp)
                    .align(Alignment.CenterEnd)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    NotificationScreen(navController = NavHostController(LocalContext.current))
}