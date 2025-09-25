package com.simec.demojectpackcompose01.ui.features.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.ui.components.CustomAppBarWithCard

/**
 * Created by Emdadul Haque Siam on 17,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun SettingsScreen(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        CustomAppBarWithCard(
            title= "Settings",
            onBackClick = {navController.popBackStack()}
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            Text(text = "Settings Screen")
        }
    }

}


