package com.simec.e_planner.ui.features.settings.event_preference

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.e_planner.R
import com.simec.e_planner.ui.theme.NunitoMedium
import com.simec.e_planner.ui.theme.NunitoSemiBold
import java.util.Calendar

/**
 * Created by Emdadul Haque Siam on 09,October,2025
 * Copyright (c): SIMEC System Ltd.
 */

@Composable
fun EventPreferenceScreen(navController: NavHostController){
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .padding(top = 10.dp)
    ) {

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Text(
                text = "Default event type",
                fontFamily = NunitoSemiBold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.level),
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)

        ) {
            Text(
                text = "Notifications",
                fontFamily = NunitoMedium,
                color = colorResource(id = R.color.CardTextColor),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ){
                Switch(
                    checked = isChecked,
                    onCheckedChange = {isChecked = it}
                )
            }
        }

        Text(
            text = "Language",
            fontFamily = NunitoMedium,
            color = colorResource(id = R.color.CardTextColor),
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 16.dp)
        )




        Column {

            Text(
                text = "Time zone",
                fontFamily = NunitoSemiBold,
                fontWeight = Bold,
                color = colorResource(id = R.color.CardTextColor),
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            )

            val context = LocalContext.current
            var selectedTime by remember { mutableStateOf("Select Time") }

            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                context,
                { _, h: Int, m: Int ->
                    selectedTime = String.format("%02d:%02d", h, m)
                }, hour, minute, true
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Selected Time: $selectedTime",
                    modifier = Modifier
                        .padding(bottom = 5.dp, start = 5.dp),
                    color = colorResource(id = R.color.MainCardColor)

                )

                Button(
                    onClick = { timePickerDialog.show() },
                    modifier = Modifier
                        .padding(horizontal = 5.dp)


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
@Preview
@Composable
fun EventPreferencePreview(){
    EventPreferenceScreen(navController = NavHostController(context = LocalContext.current))
}
