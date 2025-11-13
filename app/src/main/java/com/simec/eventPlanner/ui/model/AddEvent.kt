package com.simec.eventPlanner.ui.model

data class AddEvent(
    val name : String = "",
    val number : String = "" ,
    val email : String = "",
    val eventType : String = "",
    val participants : Int = 0,
    val date : Int = 0,
    val time : Int = 0,
    val location : String = "",
    val description : String = ""
)
