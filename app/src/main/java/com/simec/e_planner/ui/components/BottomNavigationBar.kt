package com.simec.e_planner.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Created by Emdadul Haque Siam on 22, September, 2025
 * Copyright (c): SIMEC System Ltd.
 */

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            route = "home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "Calendar",
            route = "calendar",
            selectedIcon = Icons.Filled.CalendarMonth,
            unselectedIcon = Icons.Outlined.CalendarMonth
        ),
        BottomNavigationItem(
            title = "Events",
            route = "events",
            selectedIcon = Icons.Filled.Event,
            unselectedIcon = Icons.Outlined.Event,
            badgeCount = 23
        ),
        BottomNavigationItem(
            title = "Settings",
            route = "settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        )
    )

    // ✅ Current destination track korar jonno
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = Color.White) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    // ✅ Same route e click korle abar navigate korbe na
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            // 🧠 Pop up to start destination to preserve previous states
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Avoid multiple copies of same destination
                            launchSingleTop = true
                            // Restore state instantly (no delay)
                            restoreState = true
                        }
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (isSelected) Color(0xFF1565C0) else Color.Gray
                    )
                },
                alwaysShowLabel = false,
                icon = {
                    BadgedBox(
                        badge = {
                            item.badgeCount?.takeIf { it > 0 }?.let {
                                Badge(containerColor = Color(0xFF1565C0)) {
                                    Text(
                                        text = it.toString(),
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.title,
                            tint = if (isSelected) Color(0xFF1565C0) else Color.Gray
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF1565C0),
                    selectedTextColor = Color(0xFF1565C0),
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFFE3F2FD)
                )
            )
        }
    }
}
