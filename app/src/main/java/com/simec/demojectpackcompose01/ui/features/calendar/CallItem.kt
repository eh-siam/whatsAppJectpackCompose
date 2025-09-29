package com.simec.demojectpackcompose01.ui.features.calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simec.demojectpackcompose01.R

/**
 * Created by Emdadul Haque Siam on 21,September,2025
 * Copyright (c): SIMEC System Ltd.
 */


@Composable
fun HomeItem (count: Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_1),
                contentDescription ="Profile Picture",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
            )
            Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp),
                        text = "Hello World",
                        fontWeight = Bold,
                        fontSize = 20.sp,
                        color = Color.Blue
                    )
                    Text(
                        modifier = Modifier
                            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
                        text = "Today, 10:58",
                        fontWeight = SemiBold,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
            Image(
                painter = painterResource(id = R.drawable.call),
                contentDescription ="Call",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 10.dp)

            )
        }
    }
}