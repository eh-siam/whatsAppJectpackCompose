package com.simec.ePlanner.ui.features.settings.event_analytics

import com.simec.ePlanner.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.ePlanner.ui.components.CustomAppBarWithCard
import com.simec.ePlanner.ui.components.MonthlyIncomeBarChart
import com.simec.ePlanner.ui.model.sampleMonthlyIncome
import com.simec.ePlanner.ui.theme.NunitoSemiBold

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EventAnalyticsScreen(navController: NavHostController){
    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "Event Analytics",
            onBackClick = { navController.popBackStack() }
        )}
    ){ innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White))
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text(
                    text = "Monthly Income Bar Chart",
                    fontFamily = NunitoSemiBold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.MainCardColor),
                    modifier = Modifier
                        .padding(top = 10.dp, start = 5.dp, bottom = 10.dp)
                )

                MonthlyIncomeBarChart(data = sampleMonthlyIncome)

            }
        }
    }
}

@Preview
@Composable
fun EventAnalyticsPreview(){
     EventAnalyticsScreen(navController= NavHostController(LocalContext.current))
}