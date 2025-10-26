package com.simec.e_planner.ui.features.settings.account_actions

import com.simec.e_planner.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
import com.simec.e_planner.ui.components.CustomAppBarWithCard
import com.simec.e_planner.ui.theme.NunitoSemiBold

@Composable
fun AccountActionScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomAppBarWithCard(
                title = "Account Action",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(top = 20.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.MainCardColor))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Change Password",
                        color = colorResource(id = R.color.white),
                        fontFamily = NunitoSemiBold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Delete / Deactivate",
                        color = colorResource(id = R.color.white),
                        fontFamily = NunitoSemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Logout",
                        color = colorResource(id = R.color.white),
                        fontFamily = NunitoSemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountActionPreview() {
    AccountActionScreen(navController = NavHostController(LocalContext.current))
}
