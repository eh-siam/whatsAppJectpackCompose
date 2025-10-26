package com.simec.e_planner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.simec.e_planner.ui.features.calendar.CalenderScreen
import com.simec.e_planner.ui.features.events.EventsScreen
import com.simec.e_planner.ui.features.home.HomeScreen
import com.simec.e_planner.ui.features.home.add.AddScreen
import com.simec.e_planner.ui.features.home.profile.ProfileScreen
import com.simec.e_planner.ui.features.settings.SettingsScreen
import com.simec.e_planner.ui.features.settings.account_actions.AccountActionScreen
import com.simec.e_planner.ui.features.settings.app_preference.AppPreferenceScreen
import com.simec.e_planner.ui.features.settings.event_analytics.EventAnalyticsScreen
import com.simec.e_planner.ui.features.settings.event_preference.EventPreferenceScreen
import com.simec.e_planner.ui.features.settings.organizer_tools.OrganizerToolsScreen
import com.simec.e_planner.ui.features.settings.payment.PaymentScreen
import com.simec.e_planner.ui.features.settings.payment.payout_methods.PayoutMethodsScreen
import com.simec.e_planner.ui.features.settings.support.SupportScreen


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
            HomeScreen(navController = navController)
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
            ProfileScreen(navController)
        }
        composable("add") {
            AddScreen(navController = navController)
        }

        //Settings Screen (option)
        composable("event") {
            EventPreferenceScreen(navController = navController)
        }
        composable("payments") {
            PaymentScreen(navController = navController)
        }
        composable("support") {
            SupportScreen(navController = navController)
        }
        composable("organizer") {
            OrganizerToolsScreen(navController = navController)
        }
        composable("event_analytics") {
            EventAnalyticsScreen(navController = navController)
        }
        composable("app_preference") {
            AppPreferenceScreen(navController = navController)
        }
        composable("payout_methods") {
            PayoutMethodsScreen(navController = navController)
        }
        composable("account_actions") {
            AccountActionScreen(navController = navController)
        }
    }
}