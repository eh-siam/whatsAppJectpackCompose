package com.simec.eventPlanner.ui.features.settings.event_preference

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.simec.eventPlanner.R
import com.simec.eventPlanner.ui.components.CustomAppBar
import com.simec.eventPlanner.ui.theme.NunitoMedium
import com.simec.eventPlanner.ui.theme.NunitoSemiBold
import java.util.Calendar

/**
 * Created by Emdadul Haque Siam on 09, October, 2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EventPreferenceScreen(navController: NavHostController) {

    var isNotificationEnabled by rememberSaveable { mutableStateOf(false) }
    var selectedTime by rememberSaveable { mutableStateOf("Select Time") }

    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    val timePickerDialog = remember {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                selectedTime = String.format("%02d:%02d", hour, minute)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
    }

    Scaffold(
        topBar = {
            CustomAppBar(
                title = "Event Preference",
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .padding(innerPadding)
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Text(
                    text = "Default event type",
                    fontFamily = NunitoSemiBold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.level),
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Notifications",
                    fontFamily = NunitoMedium,
                    color = colorResource(id = R.color.CardTextColor)
                )
                Switch(
                    checked = isNotificationEnabled,
                    onCheckedChange = { isNotificationEnabled = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Language",
                fontFamily = NunitoMedium,
                color = colorResource(id = R.color.CardTextColor),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Text(
                    text = "Time zone",
                    fontFamily = NunitoSemiBold,
                    fontWeight = Bold,
                    color = colorResource(id = R.color.CardTextColor)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Selected Time - $selectedTime",
                    color = colorResource(id = R.color.MainCardColor)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { timePickerDialog.show()
                    }
                ) {
                    Text(
                        text = "Pick Time",
                        color = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventPreferencePreview() {
    EventPreferenceScreen(navController = rememberNavController())
}
