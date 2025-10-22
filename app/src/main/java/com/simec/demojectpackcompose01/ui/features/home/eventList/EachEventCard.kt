package com.simec.demojectpackcompose01.ui.features.home.eventList

import androidx.compose.foundation.Image
import com.simec.demojectpackcompose01.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simec.demojectpackcompose01.ui.theme.NunitoMedium
import com.simec.demojectpackcompose01.ui.theme.NunitoRegular
import com.simec.demojectpackcompose01.ui.theme.NunitoSemiBold


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
            .padding(vertical = 10.dp, horizontal = 2.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .padding(12.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "Social Image",
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 3.dp),
                verticalArrangement = Arrangement.SpaceBetween,

                ) {

                Row(
                    modifier = Modifier
                        .padding(start = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Type :",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.level),
                        fontFamily = NunitoMedium,
                        modifier = Modifier
                            .padding(end = 5.dp)

                    )
                    Text(
                        text = "Social Event",
                        fontSize = 13.sp,
                        color = colorResource(id = R.color.result),
                        fontFamily =  NunitoSemiBold,
                        fontWeight = Bold,
                        modifier = Modifier
                        // you can align it to the end if you want
                    )
                }
                Row(
                    verticalAlignment =
                        Alignment.CenterVertically
                ) {
                    Text(
                        text = "Persons :",
                        fontSize = 12.sp,
                        fontFamily =  NunitoMedium,
                        color = colorResource(id = R.color.level),
                        modifier = Modifier
                            .padding(end = 5.dp, start = 3.dp)
                    )
                    Text(
                        text = "120",
                        fontSize = 13.sp,
                        fontWeight = Bold,
                        fontFamily = NunitoSemiBold,
                        color = colorResource(id = R.color.result),
                        modifier = Modifier
                        // you can align it to the end if you want
                    )
                }
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text ="Date :",
                        fontSize = 12.sp,
                        fontFamily =  NunitoMedium,
                        color = colorResource(id = R.color.level),
                        modifier = Modifier
                            .padding(end = 5.dp, start = 3.dp)

                    )
                    Text(
                        text = "09-10-25",
                        fontWeight= Bold,
                        fontSize = 13.sp,
                        fontFamily =  NunitoSemiBold,
                        color = colorResource(id = R.color.result),

                        )
                }

                Row  (
                    modifier = Modifier
                        .padding(1.dp)
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = "Time :",
                        fontFamily =  NunitoMedium,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.level),
                        modifier = Modifier
                            .padding(end = 5.dp, start = 2.dp, top = 1.dp)
                    )
                    Text(
                        text = "02:30 PM",
                        fontWeight = Bold,
                        fontSize = 13.sp,
                        fontFamily =  NunitoSemiBold,
                        color = colorResource(id = R.color.result),
                        modifier = Modifier

                    )
                }


                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Location :",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.level),
                        fontFamily =  NunitoMedium,
                        modifier = Modifier
                            .padding(start = 3.dp ,end = 5.dp)
                    )
                    Text(
                        text = "127,Sec 12,Uttara",
                        modifier = Modifier,
                        fontWeight = Bold,
                        fontSize = 13.sp,
                        maxLines = 2,
                        fontFamily =  NunitoSemiBold,
                        color = colorResource(id = R.color.result),
                        // you can align it to the end if you want
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEachEventCard(){
    EachEventCard(count = 2)
}