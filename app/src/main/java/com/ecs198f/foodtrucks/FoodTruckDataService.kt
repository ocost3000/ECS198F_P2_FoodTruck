package com.ecs198f.foodtrucks

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodTruckDataService {
    @GET("/food-trucks")
    fun listFoodTrucks(): Call<List<FoodTruck>>

    @GET("/food-trucks/{truckId}/items")
    fun listTruckFoodItems(@Path("truckId") id: String): Call<List<FoodItem>>
}