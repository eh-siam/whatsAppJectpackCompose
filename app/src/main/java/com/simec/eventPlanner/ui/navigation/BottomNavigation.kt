package com.simec.eventPlanner.ui.navigation

import EventsScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simec.eventPlanner.ui.components.BottomNavigationBar
import com.simec.eventPlanner.ui.features.home.HomeScreen
import com.simec.eventPlanner.ui.features.notification.NotificationScreen
import com.simec.eventPlanner.ui.features.settings.SettingsScreen

@Composable
fun BottomNavigation(mainNavController: NavHostController) {
    val nestedNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = nestedNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = nestedNavController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(mainNavController)
            }
            composable("notification") {
                NotificationScreen(mainNavController)
            }
            composable("events") {
                EventsScreen(mainNavController)
            }
            composable("settings") {
                SettingsScreen(mainNavController)
            }
        }
    }
}
