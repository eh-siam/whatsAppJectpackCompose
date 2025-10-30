package com.simec.ePlanner.ui.features.settings.account_actions.deactivate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.simec.ePlanner.R
import com.simec.ePlanner.ui.components.CustomAppBarWithCard
import com.simec.ePlanner.ui.theme.NunitoSemiBold

@Composable
fun DeactivateScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomAppBarWithCard(
                title = "Delete or Deactivate",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(paddingValues)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text(
                text = "Deactivating your account will hide your profile temporarily and you won’t be able to use certain features.\n" +
                        "Deleting your account is permanent and all your data will be lost.",
                modifier = Modifier
                    .padding(vertical = 1.dp),
                color = colorResource(id = R.color.title),
                fontFamily = NunitoSemiBold,
            )

            // Deactivate Button
            Button(
                onClick = { /* Handle deactivate */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Text(text = "Deactivate Account", color = Color.Black)
            }

            // Delete Button
            Button(
                onClick = { /* Handle delete */ },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Delete Account", color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))

            // Optional: Support Info
            Text(
                text = "If you face issues, contact support.",
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }
    }
}
