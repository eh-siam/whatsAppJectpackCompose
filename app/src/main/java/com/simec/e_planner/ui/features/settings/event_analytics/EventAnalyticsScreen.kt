package com.simec.e_planner.ui.features.settings.event_analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.simec.e_planner.ui.components.CustomAppBarWithCard

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EventAnalyticsScreen(navController: NavHostController){

    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "Event Analytics",
            onBackClick = { navController.popBackStack() }
        )}
    ){ innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)){

        }

    }

}

@Preview
@Composable
fun EventAnalyticsPreview(){
     EventAnalyticsScreen(navController= NavHostController(LocalContext.current))
}