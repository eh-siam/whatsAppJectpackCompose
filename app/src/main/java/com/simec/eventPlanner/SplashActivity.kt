package com.simec.eventPlanner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest



class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreenUI()  // NavController nai
        }

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 2000)
    }
}


@Composable
fun SplashScreenUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.MainCardColor))
    ) {
        // Content
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //Drawable → Image()
            Image(
                painter = painterResource(id = R.drawable.confetti),
                contentDescription = "Event Planner",
                colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .size(80.dp)

            )

            //Coil best choice for jetpack compose
            //API Image → Coil (AsyncImage)
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("")
                    .crossfade(true)
                    .build(),
                contentDescription = "Event Planner",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .size(80.dp),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Event Planner",
                fontSize = 50.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold
            )
        }
    }
}


