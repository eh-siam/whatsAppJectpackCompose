package com.simec.eventPlanner.ui.features.home.profile.edit_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.simec.eventPlanner.ui.components.CustomAppBar

@Composable
fun EditProfileScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Edit Profile",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
            .padding(innerPadding)
                .background(colorResource(id = com.simec.eventPlanner.R.color.white))
                .fillMaxWidth()
        ){

            Divider(
                color = colorResource(id = com.simec.eventPlanner.R.color.grey),
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Edit Profile Screen",
                modifier = Modifier
                    .padding(16.dp)
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileScreenPreview(){
    EditProfileScreen(navController = rememberNavController())
}

