package com.simec.eventPlanner.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.simec.eventPlanner.ui.auth.logIn.LoginScreen
import com.simec.eventPlanner.ui.auth.registration.RegistrationScreen
import com.simec.eventPlanner.ui.features.home.add.AddScreen
import com.simec.eventPlanner.ui.features.home.profile.ProfileScreen
import com.simec.eventPlanner.ui.features.settings.account_actions.AccountActionScreen
import com.simec.eventPlanner.ui.features.settings.account_actions.change_password.ChangePasswordScreen
import com.simec.eventPlanner.ui.features.settings.account_actions.deactivate.DeactivateScreen
import com.simec.eventPlanner.ui.features.settings.app_preference.AppPreferenceScreen
import com.simec.eventPlanner.ui.features.settings.income_analytics.EventAnalyticsScreen
import com.simec.eventPlanner.ui.features.settings.event_preference.EventPreferenceScreen
import com.simec.eventPlanner.ui.features.settings.organizer_tools.OrganizerToolsScreen
import com.simec.eventPlanner.ui.features.settings.payment.PaymentScreen
import com.simec.eventPlanner.ui.features.settings.payment.payout_methods.PayoutMethodsScreen
import com.simec.eventPlanner.ui.features.settings.support.SupportScreen


@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route, // Start with the main screen that has the bottom nav
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Registration.route) {
            RegistrationScreen(navController = navController)
        }
        composable(Screen.Main.route) {
            BottomNavigation(mainNavController = navController) // The screen with the Scaffold and bottom nav
        }

        // --- Other screens without bottom navigation ---
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("add") {
            AddScreen(navController = navController)
        }
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
        composable("changePassword") {
            ChangePasswordScreen(navController = navController)
        }
        composable("deactivate") {
            DeactivateScreen(navController = navController)
        }
    }
}