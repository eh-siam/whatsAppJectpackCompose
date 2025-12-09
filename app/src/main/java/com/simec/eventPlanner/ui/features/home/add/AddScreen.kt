package com.simec.eventPlanner.ui.features.home.add

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.simec.eventPlanner.R
import com.simec.eventPlanner.data.enumData.EventTypeCategory
import com.simec.eventPlanner.ui.theme.NunitoMedium


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavHostController? = null) {

    var eventName by remember { mutableStateOf("") }
    var registrantName by remember { mutableStateOf("") }
    var registrantContactNumber by remember { mutableStateOf("") }
    var registrantEmail by remember { mutableStateOf("") }
    var selectedEventType by remember { mutableStateOf("") }
    var totalParticipants by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    val eventTypes = remember { EventTypeCategory.getAllTypes() }

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.white))
                .fillMaxWidth()
                .padding(top = 16.dp, start = 10.dp, end = 16.dp, bottom = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_blue),
                contentDescription = "Back",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterStart)
                    .clickable { navController?.popBackStack() }
            )
            Text(
                text = "Create an Event",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.MainCardColor),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Form
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Event Name
            Row {
                Text(
                    text = "Event Name",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)
                )
            }
            OutlinedTextField(
                value = eventName,
                onValueChange = { eventName = it },
                placeholder = { Text("Enter Event Name", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Registrant Name
            Row {

                Text(
                    text = "Registrant Name",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)
                )
            }

            OutlinedTextField(
                value = registrantName,
                onValueChange = { registrantName = it },
                placeholder = { Text("Enter Registrant Name", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Registrant Contact Number
            Row {
                Text(
                    text = "Registrant Contact Number",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )

                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)
                )

            }

            OutlinedTextField(
                value = registrantContactNumber,
                onValueChange = { registrantContactNumber = it },
                placeholder = { Text("Enter Contact Number", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Registrant Email
            Row {
                Text(
                    text = "Registrant Email ",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)

                )
            }

            OutlinedTextField(
                value = registrantEmail,
                onValueChange = { registrantEmail = it },
                placeholder = { Text("Enter Email", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Event Type Dropdown
            Row {
                Text(
                    text = "Event Type ",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)

                )
            }

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = selectedEventType,
                    onValueChange = {},
                    readOnly = true,
                    placeholder = {
                        if (selectedEventType.isEmpty())
                            Text("Select Event Type", color = Color.Gray)
                    },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .border(
                            width = 0.7.dp,
                            color = colorResource(id = R.color.title),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                AnimatedVisibility(
                    visible = expanded,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        eventTypes.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(item) },
                                onClick = {
                                    selectedEventType = item
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Total Participants
            Row {
                Text(
                    text = "Total Participants ",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)
                )
            }

            OutlinedTextField(
                value = totalParticipants,
                onValueChange = { totalParticipants = it },
                placeholder = { Text("Enter total participants", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Event Date
            Row {
                Text(
                    text = "Date  ",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )
                Text(
                    text = "*",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.Star)
                )
            }
            OutlinedTextField(
                value = eventDate,
                onValueChange = { eventDate = it },
                placeholder = { Text("Select Date", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Event Time
            Text(text = "Time *", fontFamily = NunitoMedium, fontSize = 14.sp)
            OutlinedTextField(
                value = eventTime,
                onValueChange = { eventTime = it },
                placeholder = { Text("Select Time", color = Color.Gray) },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Location
            Text(text = "Location *", fontFamily = NunitoMedium, fontSize = 14.sp)
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                placeholder = { Text("Enter Location", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                shape = RoundedCornerShape(8.dp)
            )

            // Add Button
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.MainCardColor))
            ) {
                Text(text = "Add Event", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddScreen() {
    AddScreen(navController = NavHostController(LocalContext.current))
}
