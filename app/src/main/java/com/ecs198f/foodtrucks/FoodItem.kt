package com.ecs198f.foodtrucks

import java.text.NumberFormat

data class FoodItem(
    val id: String,
    val truckId: String,
    val name: String,
    val description: String,
    val price: Double,
    val taxIncluded: Boolean
) {
    val formattedPrice: String
        get() = NumberFormat.getCurrencyInstance().format(price)
}
