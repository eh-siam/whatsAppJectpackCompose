package com.simec.eventPlanner

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.auth.FirebaseAuth
import com.simec.eventPlanner.ui.app.MyApp
import com.simec.eventPlanner.ui.navigation.Screen
import com.simec.eventPlanner.ui.theme.EPlanner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val auth = FirebaseAuth.getInstance()
        Log.d("MainActivity", "Current user: ${auth.currentUser?.email}")

        val startDestination = if (auth.currentUser != null) {
            Screen.Main.route
        } else {
            Screen.Login.route
        }

        setContent {
            EPlanner {
                MyApp(startDestination = startDestination)
            }
        }
    }
}
