package com.simec.eventPlanner.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Registration : Screen("registration")
    object Main : Screen("main")
}