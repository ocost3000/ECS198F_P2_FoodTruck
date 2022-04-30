package com.ecs198f.foodtrucks

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodTruckService {
    // Define endpoints

    // list of food truck objects
    @GET("/food-trucks")
    fun listFoodTrucks(): Call<List<FoodTruck>>

    // details of a specific food truck
    @GET("/food-trucks/{id}")
    fun getFoodTruckData(@Path("id") id: Int): Call<FoodTruck>
}