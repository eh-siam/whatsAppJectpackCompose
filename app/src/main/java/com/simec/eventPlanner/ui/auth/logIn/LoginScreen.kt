package com.simec.eventPlanner.ui.auth.logIn

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.simec.eventPlanner.MainActivity
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    val uiState by loginViewModel.uiState.collectAsState()
    val loginResult by loginViewModel.logResult.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = R.drawable.appstore),
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.email,
            onValueChange = { loginViewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.password,
            onValueChange = { loginViewModel.onPasswordChange(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { loginViewModel.login() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.MainCardColor),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(5.dp)
            )
        }

        loginResult?.let {
            when(it){
                is LoginResult.Success -> {

                    val prefs = context.getSharedPreferences("my_prefs", 0)
                    prefs.edit().putBoolean("isLoggedIn", true).apply()

                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

                    navController.navigate(Screen.Main.route){
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
                is LoginResult.Error -> {
                    Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { navController.navigate(Screen.Registration.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                    shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                "Don't have an account? Register",
                color = colorResource(id = R.color.MainCardColor),
                modifier = Modifier.padding(5.dp)

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}
