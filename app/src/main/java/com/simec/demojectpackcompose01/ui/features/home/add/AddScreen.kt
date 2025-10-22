package com.simec.demojectpackcompose01.ui.features.home.add

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.simec.demojectpackcompose01.R
import com.simec.demojectpackcompose01.data.enumData.EventType
import com.simec.demojectpackcompose01.ui.components.CustomAppBarWithCard
import com.simec.demojectpackcompose01.ui.theme.NunitoMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavHostController? = null) {

    val items = EventType.getAllTypes()

    var expanded by remember { mutableStateOf(false) }
    var selectedEventType by remember { mutableStateOf("") }

    // Fields state
    var registrantName by remember { mutableStateOf("") }
    var registrantContactNumber by remember { mutableStateOf("") }
    var registrantEmail by remember { mutableStateOf("") }
    var totalParticipants by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = { CustomAppBarWithCard(title = "Add Event", onBackClick = { navController?.popBackStack() }) }
    ) { innerPadding ->

        Spacer(modifier = Modifier.height(5.dp))


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())

        ){

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .background(colorResource(id = R.color.white))
            ) {

                //Registrant Name
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
                Text(text = "Registrant Contact Number *", fontFamily = NunitoMedium, fontSize = 14.sp)
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
                Text(text = "Registrant Email *", fontFamily = NunitoMedium, fontSize = 14.sp)
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
                Text(
                    text = "Event Type *",
                    fontFamily = NunitoMedium,
                    fontSize = 14.sp
                )

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
                                width = 1.dp,
                                color = colorResource(id = R.color.MainCardColor),
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
                    // ✅ Smooth Animated Dropdown
                    AnimatedVisibility(
                        visible = expanded,
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut()
                    ) {
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            items.forEach { item ->
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
                Text(text = "Total Participants *", fontFamily = NunitoMedium, fontSize = 14.sp)
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
                Text(text = "Date *", fontFamily = NunitoMedium, fontSize = 14.sp)
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
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Location
                Text(text = "Location *", fontFamily = NunitoMedium, fontSize = 14.sp)
                OutlinedTextField(
                    value = location,
                    onValueChange = { location = it },
                    placeholder = { Text("Enter Location", color = Color.Gray) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Description
                Text(text = "Description", fontFamily = NunitoMedium, fontSize = 14.sp)
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    placeholder = { Text("Enter Description", color = Color.Gray) },
                    singleLine = false,
                    maxLines = 5,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Handle Submit */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.MainCardColor), // background color
                        contentColor = Color.White // text color
                    )
                ) {
                    Text(
                        text = "Create Event",
                        fontSize = 16.sp,
                        fontFamily = NunitoMedium,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                    )
                }


            }
            
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddScreen() {
    AddScreen(navController = null)
}
