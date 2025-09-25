package com.simec.demojectpackcompose01.ui.features.home.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.ui.components.CustomAppBarWithCard

/**
 * Created by Emdadul Haque Siam on 24,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun ProfileScreen(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        CustomAppBarWithCard(
            title= "Profile",
            onBackClick = {navController.popBackStack()}
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ){
            Text(text = "Profile Screen")
        }
    }
}