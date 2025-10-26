package com.simec.e_planner.ui.features.settings.account_actions

import com.simec.e_planner.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.simec.e_planner.ui.components.CustomAppBarWithCard

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun AccountActionScreen(navController: NavHostController){
    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "Account Action",
            onBackClick = { navController.popBackStack() }
        )}
    ){ innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)){
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            Card (
                modifier = Modifier
                    .size(height = 60.dp, width = 400.dp)
                    .padding(horizontal = 16.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.MainCardColor))
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountActionPreview(){
    AccountActionScreen(navController = NavHostController(LocalContext.current))
}
