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
                color = colorResource(id = R.color.purple_700),
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                    navController?.navigate("add")
                }
            )
        }


          Card(modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 16.dp, horizontal = 20.dp)
              .background(Color.Blue),
              shape = RoundedCornerShape(5.dp),
              border = BorderStroke(1.dp, Color.Blue),
              elevation = CardDefaults.cardElevation(2.dp)
          ){
              
              Text(
                  text = "This Month’s Summary",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,
                  color = Color.White,
              )


          }




          Column(
              modifier = Modifier
                  .verticalScroll(state = rememberScrollState())

          ){

              Column (
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 16.dp, vertical = 5.dp)
              ){
                  Box(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(top = 10.dp),
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
                          color = colorResource(id = R.color.purple_700),
                          modifier = Modifier
                              .align(Alignment.CenterEnd),
                      )
                  }
                  Column(
                      modifier = Modifier
                          .padding( vertical = 10.dp)
                  ) {
                      LazyColumn(
                          modifier = Modifier
                              .height(360.dp)

                      ) {

                          items(2){
                                  index -> EachEventCard(count = index)
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
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontSize = 16.sp,
                                  fontWeight = FontWeight.Medium,
                                  color = Color.Black,
                                  modifier = Modifier
                                      .padding(top = 3.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontWeight = FontWeight.Bold,
                                  modifier = Modifier
                                      .padding(top = 3.dp)

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
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontSize = 16.sp,
                                  fontWeight = FontWeight.Medium,
                                  color = Color.Black,
                                  modifier = Modifier
                                      .padding(top = 3.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontSize = 16.sp,
                                  color = Color.Black

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
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontSize = 16.sp,
                                  fontWeight = FontWeight.Medium,
                                  color = Color.Black,
                                  modifier = Modifier
                                      .padding(top = 3.dp)
                              )
                          }
                      }

                      Card(
                          modifier = Modifier
                              .weight(1f)
                              .height(120.dp),
                          elevation = CardDefaults.cardElevation(2.dp),
                          shape = RoundedCornerShape(10.dp),
                          border = BorderStroke(1.dp, Color.Blue),
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
                                  fontWeight = FontWeight.Bold,
                                  modifier = Modifier
                                      .padding(top = 3.dp)

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

