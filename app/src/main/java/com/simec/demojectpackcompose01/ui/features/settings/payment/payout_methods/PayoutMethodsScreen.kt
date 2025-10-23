package com.simec.demojectpackcompose01.ui.features.settings.payment.payout_methods

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.ui.components.CustomAppBarWithCard

@Composable
fun PayoutMethodsScreen(navController: NavHostController){
    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "Payout Methods",
            onBackClick = { navController.popBackStack() }
        )}
    ){ innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)){

        }

    }
}
@Preview
@Composable
fun PayoutMethodsPreview(){
    PayoutMethodsScreen(navController = NavHostController(LocalContext.current))
}