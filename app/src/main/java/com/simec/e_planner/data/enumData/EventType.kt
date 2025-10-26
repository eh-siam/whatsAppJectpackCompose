package com.simec.e_planner.data.enumData

enum class EventType(val displayName: String) {
    WEDDING("Wedding"),
    BIRTHDAY("Birthday"),
    CONFERENCE("Conference"),
    WORKSHOP("Workshop"),
    WEBINAR("Webinar"),
    MEETUP("Meetup");

    companion object {
        fun getAllTypes(): List<String> {
            return values().map { it.displayName }
        }
    }
}
