package com.simec.eventPlanner.ui.features.home.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.simec.eventPlanner.ui.components.CustomAppBar

/**
 * Created by Emdadul Haque Siam on 24,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = { CustomAppBar(
            title = "Profile",
            onBackClick = { navController.popBackStack() }
        )}
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)) {

            Text(
                text = "Profile Screen",
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 10.dp)

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}
