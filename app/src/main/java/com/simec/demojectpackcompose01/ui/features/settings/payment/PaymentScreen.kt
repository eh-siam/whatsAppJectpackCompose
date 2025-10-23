package com.simec.demojectpackcompose01.ui.features.settings.payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.R
import com.simec.demojectpackcompose01.ui.components.CustomAppBarWithCard
import com.simec.demojectpackcompose01.ui.theme.NunitoSemiBold

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun PaymentScreen(navController: NavHostController){
    Scaffold(
        topBar = { CustomAppBarWithCard(
            title = "Payment & Billing",
            onBackClick = { navController.popBackStack() }
        )}
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.White)) {

            Text(
                text = "Earnings Overview",
                fontFamily = NunitoSemiBold,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)

            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {


                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                            border = BorderStroke(1.dp, colorResource(id = R.color.SecondaryCardColor)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .background(colorResource(id = R.color.MainCardColor)),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.save_money),
                            contentDescription = "Total Earnings",
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.white))

                        )
                        Text(
                            text ="Total Earnings",
                            fontSize = 13.sp,
                            fontFamily = NunitoSemiBold,
                            color = colorResource(id = R.color.white),
                            modifier = Modifier
                                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .background(colorResource(id = R.color.MainCardColor))
                                .align(Alignment.CenterHorizontally),

                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Text(
                                text = "Tk.",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(vertical = 7.dp)

                            )
                            Text(
                                text = "3,250",
                                fontSize = 14.sp,
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(top = 7.dp, bottom = 10.dp)

                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.padding(7.dp))

                Card (
                    modifier = Modifier
                        .fillMaxWidth(),
                    border = BorderStroke(1.dp, colorResource(id = R.color.SecondaryCardColor)),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Column(
                        modifier = Modifier
                            .background(colorResource(id = R.color.MainCardColor))
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.money),
                            contentDescription = "Total Earnings",
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.white))

                        )

                        Text(
                            text = "Pending Payouts ",
                            fontSize = 13.sp,
                            fontFamily = NunitoSemiBold,
                            color = colorResource(id = R.color.white),
                            modifier = Modifier
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .background(colorResource(id = R.color.MainCardColor))
                                .align(Alignment.CenterHorizontally),
                            horizontalArrangement = Arrangement.spacedBy(3.dp)


                        ) {
                            Text(
                                text = "Tk.",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(vertical =7.dp)

                            )
                            Text(
                                text = "420",
                                fontSize = 14.sp,
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(top = 7.dp, bottom = 10.dp)

                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.padding(7.dp))


                Card (
                    modifier = Modifier
                        .fillMaxWidth(),
                    border = BorderStroke(1.dp, colorResource(id = R.color.SecondaryCardColor)),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Column(
                        modifier = Modifier
                            .background(colorResource(id = R.color.MainCardColor)),
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.revenue),
                            contentDescription = "Total Earnings",
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
                        )
                        Text(
                            text = "Monthly Revenue",
                            fontSize = 13.sp,
                            fontFamily = NunitoSemiBold,
                            color = colorResource(id = R.color.white),
                            modifier = Modifier
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)

                        )
                        Row(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(horizontal = 16.dp)
                                .background(colorResource(id = R.color.MainCardColor)),
                            horizontalArrangement = Arrangement.spacedBy(3.dp)


                        ) {
                            Text(
                                text = "Tk.",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(vertical = 7.dp)

                            )
                            Text(
                                text = "880",
                                fontSize = 14.sp,
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .padding(top = 7.dp, bottom = 10.dp)

                            )
                        }
                    }
                }
            }


            Text(
                text = "Financial Management",
                fontFamily = NunitoSemiBold,
                color = colorResource(id = R.color.title),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)

            )

            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, colorResource(id = R.color.SubCardColor)),
                    onClick = { navController.navigate("payout_methods") }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.SubCardColor))
                            .padding(vertical = 16.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.payout),
                                contentDescription = "payouts",
                                colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Payout Methods",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow__12_),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }



                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, colorResource(id = R.color.SubCardColor)),
                    onClick = { navController.navigate("transaction_history") }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.SubCardColor))
                            .padding(vertical = 16.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.transaction),
                                contentDescription = "payouts",
                                colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Transaction History",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow__12_),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, colorResource(id = R.color.SubCardColor)),
                    onClick = { navController.navigate("tax_and_billing_info") }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.SubCardColor))
                            .padding(vertical = 16.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.tax),
                                contentDescription = "payouts",
                                colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Tax & Billing Info",
                                fontFamily = NunitoSemiBold,
                                color = colorResource(id = R.color.white)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.arrow__12_),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun PaymentAndBillingPreview(){
    PaymentScreen(navController = NavHostController(context = LocalContext.current))
}
