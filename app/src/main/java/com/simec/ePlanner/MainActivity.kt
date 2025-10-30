package com.simec.ePlanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.simec.ePlanner.ui.app.MyApp
import com.simec.ePlanner.ui.theme.EPlanner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EPlanner {
                MyApp() // ✅ Entry point
            }
        }
    }
}
