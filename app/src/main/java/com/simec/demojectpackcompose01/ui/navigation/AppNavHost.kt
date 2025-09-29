package com.simec.demojectpackcompose01.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.simec.demojectpackcompose01.ui.features.calendar.CalenderScreen
import com.simec.demojectpackcompose01.ui.features.events.EventsScreen
import com.simec.demojectpackcompose01.ui.features.home.HomeScreen
import com.simec.demojectpackcompose01.ui.features.home.profile.ProfileScreen
import com.simec.demojectpackcompose01.ui.features.settings.SettingsScreen


/**
 * Created by Emdadul Haque Siam on 17,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun AppNavHost(navController: NavHostController , modifier : Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier

    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("calendar") {
            CalenderScreen(navController)
        }
        composable("events") {
            EventsScreen(navController)
        }
        composable("settings") {
            SettingsScreen(navController)
        }

        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("add") {
            ProfileScreen(navController = navController)
        }
    }
}