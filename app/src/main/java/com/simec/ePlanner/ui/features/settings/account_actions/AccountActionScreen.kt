package com.simec.ePlanner.ui.features.settings.account_actions

import androidx.compose.foundation.Image
import com.simec.ePlanner.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.simec.ePlanner.ui.components.CustomAppBarWithCard
import com.simec.ePlanner.ui.theme.NunitoMedium
import com.simec.ePlanner.ui.theme.NunitoSemiBold

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
                .padding(top = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.SubOneCardColor))
                        .padding(16.dp)
                ) {
                    Row (
                        modifier = Modifier
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.padlock),
                            contentDescription = "Profile Image",
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                            modifier = Modifier
                                .size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "Manage Your Account",
                            color = colorResource(id = R.color.white),
                            fontFamily = NunitoSemiBold,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(top = 3.dp)
                        )
                    }
                    Text(
                        text = "Easily control your account settings, update security preferences, or log out when you’re done.",
                        color = colorResource(id = R.color.white),
                        fontFamily = NunitoSemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )


                    Text(
                        text = "Update credentials, privacy, or sign out. ",
                        color = colorResource(id = R.color.white),
                        fontFamily = NunitoSemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }
            }
                Text(
                    text = "Manage Your Account",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 16.dp),
                    color = colorResource(id = R.color.MainCardColor),
                    fontFamily = NunitoSemiBold,
                    fontSize = 16.sp,

                )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)

            ){
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(2.dp),
                    onClick = {
                        navController.navigate("changePassword")
                    }
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white)),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.padlock),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .padding(start = 16.dp, bottom = 8.dp)
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.MainCardColor)),
                            )

                        Column(
                            modifier = Modifier
                                .padding(vertical =8.dp, horizontal = 16.dp)
                        ) {

                            Text(
                                text = "Change Password",
                                modifier = Modifier
                                    .padding(vertical = 1.dp),
                                color = colorResource(id = R.color.title),
                                fontFamily = NunitoSemiBold,
                            )

                            Text(
                                text = "Update your login password. ",
                                modifier = Modifier,
                                color = colorResource(id = R.color.level),
                                fontFamily = NunitoMedium,
                                fontSize = 12.sp
                            )
                        }


                        Spacer(modifier = Modifier.width(70.dp))

                        Image(
                            painter = painterResource(id = R.drawable.arrow__11_),
                            contentDescription = "Profile Image"
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(2.dp),
                    onClick = {
                        navController.navigate("deactivate")
                    }
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white)),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.asdfg),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .padding(start = 16.dp, bottom = 10.dp)
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.MainCardColor)),

                            )
                        Column(
                            modifier = Modifier
                                .padding(vertical =8.dp, horizontal = 16.dp)
                        ) {
                            Text(
                                text = "Delete / Deactivate",
                                modifier = Modifier
                                    .padding(vertical = 1.dp),
                                color = colorResource(id = R.color.title),
                                fontFamily = NunitoSemiBold,
                            )


                            Text(
                                text = "Manage or remove your account.",
                                modifier = Modifier,
                                color = colorResource(id = R.color.level),
                                fontFamily = NunitoMedium,
                                fontSize = 12.sp
                            )

                        }


                        Spacer(modifier = Modifier.width(55.dp))

                        Image(
                            painter = painterResource(id = R.drawable.arrow__11_),
                            contentDescription = "Profile Image"
                        )
                    }
                }





                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(2.dp),
                    onClick = {
                        navController.navigate("logout")
                    }
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white)),
                        verticalAlignment = Alignment.CenterVertically,

                    ){


                        Image(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .padding(start = 16.dp, bottom = 10.dp)
                                .size(24.dp),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.Star)),

                            )


                        Column (
                            modifier = Modifier
                                .padding(vertical =8.dp, horizontal = 16.dp)
                        ){
                            Text(
                                text = "Logout",
                                modifier = Modifier
                                    .padding(vertical = 1.dp),
                                color = colorResource(id = R.color.Star),
                                fontFamily = NunitoSemiBold,
                            )

                            Text(
                                text = "Sign out from this device. ",
                                modifier = Modifier,
                                color = colorResource(id = R.color.Star),
                                fontFamily = NunitoSemiBold,
                                fontSize = 12.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(88.dp))

                        Image(
                            painter = painterResource(id = R.drawable.arrow__11_),
                            colorFilter = ColorFilter.tint(colorResource(id = R.color.Star)),
                            contentDescription = "Profile Image"
                        )
                    }
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
