package com.simec.demojectpackcompose01.ui.features.home.eventList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Emdadul Haque Siam on 28,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EachEventCard(count : Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 7.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,

        ) {

            Row(
                modifier = Modifier
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Type :",
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Social Event",
                    fontWeight = Bold,
                    modifier = Modifier
                    // you can align it to the end if you want
                )
            }
            Row(
                modifier = Modifier
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Persons :",
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                Text(
                    text = "120",
                    fontWeight = Bold,
                    modifier = Modifier
                    // you can align it to the end if you want
                )
            }
            Row(
                modifier = Modifier
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Date :",
                    modifier = Modifier
                        .padding(end = 5.dp)

                )
                Text(
                    text = "09-10-25",
                    fontWeight= Bold,
                    fontSize = 14.sp,

                )
            }

            Row  (
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.Start)
            ) {
                Text(
                    text = "Time :",
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                Text(
                    text = "02:30 PM",
                    fontWeight = Bold,
                    modifier = Modifier
                    // you can align it to the end if you want
                )
            }


            Row(
                modifier = Modifier
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Location :",
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                Text(
                    text = "plot# 02,Sector 12, Uttara",
                    modifier = Modifier,
                    fontWeight = Bold
                    // you can align it to the end if you want
                )
            }




        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEachEventCard(){
    EachEventCard(count = 2)
}