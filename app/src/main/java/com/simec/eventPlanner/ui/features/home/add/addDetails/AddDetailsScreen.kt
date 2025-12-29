package com.simec.eventPlanner.ui.features.home.add.addDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.eventPlanner.ui.components.CustomAppBar

@Composable
fun AddDetailsScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Event Details",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(colorResource(id = com.simec.eventPlanner.R.color.white))
        ) {

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Event Name",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "Wedding",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }


            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Registration Name",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "Jone Doe",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }


            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Reg. Contact Number",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "01858721723",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Registration Email",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "jon78@gmail.com",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Event Type",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "Wedding",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Total Participants",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "200",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Date",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "05-08-25",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Time",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "18:32",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(0.7f),
                    text = "Location",
                    fontSize = 14.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.black)
                )
                Text(
                    text = ":"
                )
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .weight(1f),
                    text = "Army Golf Club, Tongi Diversion Rd, Dhaka 1206",
                    fontSize = 16.sp,
                    color = colorResource(id = com.simec.eventPlanner.R.color.level)
                )
            }


            Button(
                onClick = {
                    navController?.navigate("submit")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = com.simec.eventPlanner.R.color.MainCardColor))
            ) {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddDetailsScreen(){
    AddDetailsScreen(navController = NavHostController(LocalContext.current))
}
