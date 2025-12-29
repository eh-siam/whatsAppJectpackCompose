package com.simec.eventPlanner.ui.features.home.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.simec.eventPlanner.ui.components.CustomAppBar

@Composable
fun ChatScreen(navController: NavHostController){

    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Chat",
                onBackClick = { navController.popBackStack() }
            )
        }
    ){ innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)) {
        }


    }

}