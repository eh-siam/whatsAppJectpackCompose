package com.simec.eventPlanner.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.simec.eventPlanner.ui.navigation.AppNavHost

@Composable
fun MyApp() {
    val navController = rememberNavController()
    AppNavHost(
        navController = navController,
        modifier = Modifier
    )
}
