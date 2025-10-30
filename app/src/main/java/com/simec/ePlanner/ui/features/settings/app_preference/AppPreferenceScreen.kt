package com.simec.ePlanner.ui.features.settings.app_preference

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.simec.ePlanner.ui.components.CustomAppBarWithCard

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun AppPreferenceScreen(navController: NavHostController){
    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "App Preference",
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