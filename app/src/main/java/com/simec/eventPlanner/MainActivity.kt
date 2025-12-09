package com.simec.eventPlanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.simec.eventPlanner.ui.app.MyApp
import com.simec.eventPlanner.ui.navigation.Screen
import com.simec.eventPlanner.ui.theme.EPlanner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val prefs = getSharedPreferences("my_prefs", 0)
        val isLoggedIn = prefs.getBoolean("isLoggedIn", false)

        setContent {
            EPlanner {
                MyApp(startDestination = if (isLoggedIn) Screen.Main.route else Screen.Login.route) // ✅ Entry point
            }
        }
    }
}
