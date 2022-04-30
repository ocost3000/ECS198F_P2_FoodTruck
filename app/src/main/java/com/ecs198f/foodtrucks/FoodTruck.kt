package com.ecs198f.foodtrucks

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class FoodTruck(
    val id: String,
    val name: String,
    val imageUrl: String,
    val priceLevel: Int,
    val location: String,
    val openTime: String,
    val closeTime: String
) {
    val openTimeFormat: LocalDateTime = LocalDateTime.parse(openTime)
    val closeTimeFormat: LocalDateTime = LocalDateTime.parse(closeTime)

    val formattedTimeInterval: String
        get() = "${openTimeFormat.format(timeOnlyFormatter)} - ${closeTimeFormat.format(dateTimeFormatter)}"

    companion object {

        private val timeOnlyFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("hh:mm a")

        private val dateTimeFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("hh:mm a, EEE, MMM d")
    }
}
