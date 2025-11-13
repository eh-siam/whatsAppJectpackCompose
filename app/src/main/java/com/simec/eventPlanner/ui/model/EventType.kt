package com.simec.eventPlanner.ui.model

data class EventType(
    val id: String,
    val type: String ,
    val persons: Int,
    val date: String,
    val time: String,
    val location: String,
    val imageUrl: String
)
