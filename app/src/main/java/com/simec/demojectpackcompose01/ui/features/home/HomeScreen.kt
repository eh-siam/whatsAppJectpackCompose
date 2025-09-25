package com.simec.demojectpackcompose01.ui.features.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
fun HomeScreen(navController: NavHostController? = null){

    Column(modifier = Modifier
        .fillMaxSize())
      {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 40.dp),
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
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "Profile",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Center),

            )
            Image(
                painter = painterResource(R.drawable.messenger),
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterEnd)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}

