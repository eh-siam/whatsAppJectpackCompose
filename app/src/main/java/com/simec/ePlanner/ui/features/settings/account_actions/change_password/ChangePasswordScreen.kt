package com.simec.ePlanner.ui.features.settings.account_actions.change_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.ePlanner.ui.components.CustomAppBarWithCard
import com.simec.ePlanner.ui.theme.NunitoMedium

@Composable
fun ChangePasswordScreen(navController: NavHostController){


    var oldPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            CustomAppBarWithCard(
                title = "Change Password",
                onBackClick = { navController.popBackStack() }
            )
        }
    ){innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
            .padding(innerPadding)
        ) {

            // Type old Password
            Text(text = "Type old Password*",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                fontFamily = NunitoMedium,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = oldPassword,
                onValueChange = { oldPassword = it },
                placeholder = { Text("Enter old password", color = Color.Gray) },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = Color.Gray
                        )
                    }
                }
            )



            // Type New Password
            Text(text = "Type New Password*",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                fontFamily = NunitoMedium,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = { Text("Enter Type New Password", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )


            // Type New Password
            Text(text = "Confirm New Password*",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp),
                fontFamily = NunitoMedium,
                fontSize = 14.sp
            )
            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = { Text("Enter Confirm New Password", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(8.dp)
            )

        }

    }
}