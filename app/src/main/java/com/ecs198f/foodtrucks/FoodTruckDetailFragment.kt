package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ecs198f.foodtrucks.databinding.FragmentFoodTruckDetailBinding
import com.google.gson.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.time.LocalDateTime


class FoodTruckDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodTruckDetailBinding
    private val args: FoodTruckDetailFragmentArgs by navArgs()

    private val gson = GsonBuilder()
        .registerTypeAdapter(LocalDateTime::class.java, object: JsonDeserializer<LocalDateTime> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): LocalDateTime {
                return LocalDateTime.parse(json!!.asString)
            }
        })
        .registerTypeAdapter(LocalDateTime::class.java, object: JsonSerializer<LocalDateTime> {
            override fun serialize(
                src: LocalDateTime?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement {
                return JsonPrimitive(src!!.toString())
            }
        })
        .create()

    private val service = Retrofit.Builder()
        .baseUrl("https://api.foodtruck.schedgo.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(FoodTruckDataService::class.java)

    private val foodItems = listOf<FoodItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFoodTruckDetailBinding.inflate(inflater, container, false)

        val view = binding.root
        val adapter = FoodItemListRecyclerViewAdapter(foodItems)
        val foodTruck = args.foodTruck

        (activity as AppCompatActivity).supportActionBar?.title = foodTruck.name

        binding.apply {
            foodTruckDetailItemPriceLevel.text = "$".repeat(foodTruck.priceLevel)
            foodTruckDetailItemLocation.text = foodTruck.location
            foodTruckDetailItemTime.text = foodTruck.formattedTimeInterval
            foodTruckDetailRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter
            }
        }

        Glide.with(this).load(foodTruck.imageUrl).into(binding.foodTruckDetailItemImage)

        service.listTruckFoodItems(foodTruck.id).enqueue(object : Callback<List<FoodItem>> {
            override fun onResponse(
                call: Call<List<FoodItem>>,
                response: Response<List<FoodItem>>
            ) {
                adapter.updateList(response.body()!!)
            }

            override fun onFailure(call: Call<List<FoodItem>>, t: Throwable) {
                throw t
            }
        })

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.title = "Food Trucks"
    }
}