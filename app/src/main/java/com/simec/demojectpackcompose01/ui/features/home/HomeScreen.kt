package com.simec.demojectpackcompose01.ui.features.home


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.R
import com.simec.demojectpackcompose01.ui.features.home.eventList.EachEventCard
import com.simec.demojectpackcompose01.ui.theme.NunitoMedium
import com.simec.demojectpackcompose01.ui.theme.NunitoSemiBold

/**
 * Created by Emdadul Haque Siam on 17,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun HomeScreen(navController: NavHostController? = null){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    )
      {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(R.drawable.profile_1),
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(0.2.dp, Color.Black, CircleShape)
                    .align(Alignment.CenterStart)
                    .clickable {
                        navController?.navigate("profile")
                    }
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Text(
                text = "My Events",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Center),

            )
            Text(
                text = "Add(+)",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.CardTextColor),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                    navController?.navigate("add")
                }
            )
        }

          Spacer(modifier = Modifier.padding(start = 10.dp))
          Text(
              text = "Monthly Event Overview",
              fontSize = 16.sp,
              fontWeight = FontWeight.Medium,
              color = colorResource(id = R.color.title),
              modifier = Modifier
                  .padding(top = 28.dp,start = 16.dp)
              )


          Card(modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 10.dp, horizontal = 16.dp),
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
              elevation = CardDefaults.cardElevation(2.dp)
          ){
              Box {

                  Image(
                      painter = painterResource(id = R.drawable.bg_background_rectangle),
                      contentDescription = "Card design",
                      contentScale = ContentScale.Crop,
                      modifier = Modifier
                          .fillMaxWidth())

                  Column {

                      Column (
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(horizontal = 20.dp, vertical = 5.dp)
                      ){
                          Row(
                              modifier = Modifier
                                  .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                              horizontalArrangement = Arrangement.spacedBy(75.dp)
                          ) {
                              Column {

                                  Text(
                                      text = "Upcoming Events",
                                      fontSize = 13.sp,
                                      fontFamily = NunitoMedium,
                                      fontWeight = FontWeight.Medium,
                                      color = colorResource(id = R.color.CardTextColor)

                                  )
                                  Spacer(modifier = Modifier
                                      .padding(3.dp))
                                  Text(
                                      text = "24",
                                      fontSize = 16.sp,
                                      fontWeight = FontWeight.Bold,
                                      color = colorResource(id = R.color.CardTextColor),
                                      modifier = Modifier
                                          .align(Alignment.CenterHorizontally)
                                  )

                              }
                              Column{
                                  Text(
                                      text = "Ongoing Events",
                                      fontSize = 13.sp,
                                      fontFamily = NunitoMedium,
                                      fontWeight = FontWeight.Medium,
                                      color = colorResource(id = R.color.CardTextColor)

                                  )
                                  Spacer(modifier = Modifier
                                      .padding(3.dp))
                                  Text(
                                      text = "12",
                                      fontSize = 16.sp,
                                      fontWeight = FontWeight.Bold,
                                      color = colorResource(id = R.color.CardTextColor),
                                      modifier = Modifier
                                          .align(Alignment.CenterHorizontally)
                                  )

                              }
                          }
                      }

                      Column (
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(horizontal = 20.dp, vertical = 5.dp)
                      ){
                          Row(
                              modifier = Modifier
                                  .padding(top = 5.dp, start = 16.dp, end = 10.dp),
                              horizontalArrangement = Arrangement.spacedBy(70.dp)
                          ) {
                              Column {

                                  Text(
                                      text = "Completed Events ",
                                      fontSize = 13.sp,
                                      fontFamily = NunitoMedium,
                                      fontWeight = FontWeight.Medium,
                                      color = colorResource(id = R.color.CardTextColor)

                                  )
                                  Spacer(modifier = Modifier
                                      .padding(3.dp))
                                  Text(
                                      text = "06",
                                      fontSize = 16.sp,
                                      fontWeight = FontWeight.Bold,
                                      color = colorResource(id = R.color.CardTextColor),
                                      modifier = Modifier
                                          .align(Alignment.CenterHorizontally)
                                  )

                              }
                              Column{
                                  Text(
                                      text = "Rejected Events",
                                      fontSize = 13.sp,
                                      fontFamily = NunitoMedium,
                                      fontWeight = FontWeight.Medium,
                                      color = colorResource(id = R.color.CardTextColor)

                                  )
                                  Spacer(modifier = Modifier
                                      .padding(3.dp))
                                  Text(
                                      text = "02",
                                      fontSize = 16.sp,
                                      fontWeight = FontWeight.Bold,
                                      color = colorResource(id = R.color.CardTextColor),
                                      modifier = Modifier
                                          .align(Alignment.CenterHorizontally)
                                  )

                              }
                          }
                      }

                      Spacer(modifier = Modifier
                          .padding(top = 18.dp))

                      Row(
                          modifier = Modifier
                              .fillMaxWidth()
                              .background(colorResource(R.color.MainCardColor))
                              .padding(top = 12.dp)
                      ){
                          Text(
                              text = "Total Events :",
                              fontSize = 13.sp,
                              modifier = Modifier
                                  .padding(start = 120.dp, bottom = 10.dp),
                              fontFamily = NunitoMedium,
                              fontWeight = FontWeight.Medium,
                              color = colorResource(id = R.color.myCustomColor)

                          )
                          Spacer(modifier = Modifier
                              .padding(start = 10.dp))

                          Text(
                              text = "02",
                              fontSize = 16.sp,
                              fontWeight = FontWeight.Bold,
                              color = colorResource(id = R.color.myCustomColor)

                          )
                      }
                  }
              }
          }

          Column(
              modifier = Modifier
                  .verticalScroll(state = rememberScrollState())

          ){

              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp, vertical = 7.dp)
              ){
                  Box(
                      modifier = Modifier
                          .fillMaxWidth(),
                      contentAlignment = Alignment.Center

                  ) {
                      Text(
                          text = "Upcoming Event",
                          fontSize = 16.sp,
                          fontWeight = FontWeight.Medium,
                          color = colorResource(id = R.color.title),
                          modifier = Modifier
                              .align(Alignment.CenterStart),
                      )
                      Text(
                          text = "View All",
                          fontSize = 16.sp,
                          fontWeight = FontWeight.Bold,
                          color = colorResource(id = R.color.CardTextColor),
                          modifier = Modifier
                              .align(Alignment.CenterEnd),
                      )
                  }
                  Column(
                      modifier = Modifier
                  ) {
                      LazyColumn(
                          modifier = Modifier
                              .height(350.dp),
                          userScrollEnabled = false //scroll off

                      ) {
                          items(2){ index ->
                              EachEventCard(count = index)
                          }
                      }
                  }
              }
              Text(
                  text = "Event Categories",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,
                  color = colorResource(id = R.color.title),
                  modifier = Modifier
                      .padding(horizontal = 16.dp, vertical = 5.dp)
              )
              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp, vertical = 10.dp)

              ){
                  Row(
                      modifier = Modifier
                          .fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(20.dp)
                  )
                  {
                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {
                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align


                          ){
                              Image(
                                  painter = painterResource(R.drawable.dish),
                                  contentDescription = "Food Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)
                                      .align(Alignment.CenterHorizontally),

                              )
                              Spacer(modifier = Modifier.width(16.dp))
                              Text(
                                  text = "Food",
                                  fontSize = 14.sp,
                                  fontFamily = NunitoSemiBold,
                                  fontWeight = FontWeight.Medium,
                                  color = colorResource(id = R.color.CardTextColor),
                                  modifier = Modifier
                                      .padding(top = 5.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {

                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align
                          ){

                              Image(
                                  painter = painterResource(R.drawable.coordination),
                                  contentDescription = "Man Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)
                                      .align(Alignment.CenterHorizontally)
                              )
                              Spacer(modifier = Modifier.width(20.dp))



                              Text(
                                  text = "Staff Coordination",
                                  color = colorResource(id = R.color.CardTextColor),
                                  fontWeight = FontWeight.Bold,
                                  modifier = Modifier
                                      .padding(top = 5.dp),
                                  fontFamily = NunitoSemiBold,
                                  fontSize = 14.sp

                              )
                          }
                      }
                  }
              }
              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp, vertical = 10.dp)

              ){
                  Row(
                      modifier = Modifier
                          .fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(20.dp)
                  )
                  {
                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {
                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align


                          ){
                              Image(
                                  painter = painterResource(R.drawable.christmas_lights),
                                  contentDescription = "Food Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)
                                      .align(Alignment.CenterHorizontally)

                              )
                              Spacer(modifier = Modifier.width(20.dp))
                              Text(
                                  text = "Decoration",
                                  fontSize = 15.sp,
                                  fontFamily = NunitoSemiBold,
                                  fontWeight = FontWeight.Medium,
                                  color = colorResource(id = R.color.CardTextColor),
                                  modifier = Modifier
                                      .padding(top = 5.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {

                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align
                          ){

                              Image(
                                  painter = painterResource(R.drawable.budget),
                                  contentDescription = "Man Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)
                              )
                              Spacer(modifier = Modifier.width(20.dp))



                              Text(
                                  text = "Budget",
                                  fontWeight = FontWeight.Bold,
                                  modifier = Modifier
                                      .padding(top = 5.dp),
                                  fontSize = 15.sp,
                                  fontFamily = NunitoSemiBold,
                                  color = colorResource(id = R.color.CardTextColor)

                              )
                          }

                      }
                  }
              }
              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp, vertical = 10.dp)

              ){
                  Row(
                      modifier = Modifier
                          .fillMaxWidth(),
                      horizontalArrangement = Arrangement.spacedBy(20.dp)
                  )
                  {
                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {
                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align


                          ){
                              Image(
                                  painter = painterResource(R.drawable.task_list),
                                  contentDescription = "Food Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)

                              )
                              Spacer(modifier = Modifier.width(20.dp))
                              Text(
                                  text = "Task List",
                                  fontSize = 15.sp,
                                  fontFamily = NunitoSemiBold,
                                  fontWeight = FontWeight.Medium,
                                  color = colorResource(id = R.color.CardTextColor),
                                  modifier = Modifier
                                      .padding(top = 5.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, colorResource(id = R.color.MainCardColor)),
                          colors = CardDefaults.cardColors(
                              containerColor = Color.White
                          )

                      ) {

                          Column(
                              modifier = Modifier
                                  .padding(20.dp)
                                  .align(Alignment.CenterHorizontally),
                              horizontalAlignment = Alignment.CenterHorizontally // Center align
                          ){

                              Image(
                                  painter = painterResource(R.drawable.notes),
                                  contentDescription = "Man Pic",
                                  modifier = Modifier
                                      .size(50.dp)
                                      .clip(CircleShape)
                              )
                              Spacer(modifier = Modifier.width(20.dp))

                              Text(
                                  text = "Notes",
                                  fontSize = 15.sp,
                                  fontFamily = NunitoSemiBold,
                                  fontWeight = FontWeight.Bold,
                                  modifier = Modifier
                                      .padding(top = 5.dp),
                                  color = colorResource(id = R.color.CardTextColor)

                              )
                          }
                      }
                  }
              }

          }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}

