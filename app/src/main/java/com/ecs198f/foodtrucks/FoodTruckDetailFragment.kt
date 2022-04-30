package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodTruckDetailFragment : Fragment() {

    val foodTruckService: FoodTruckService = (requireActivity() as MainActivity).service

    // handle arguments specified in nav_graph
    private val args: FoodTruckDetailFragmentArgs by navArgs()

    val foodItems = listOf<FoodItem>(
        FoodItem(
        "1-1",
        "1",
        "Falafel Gyro",
        "",
        9.25,
        false
        ),
        FoodItem(
            "1-2",
            "1",
            "Chicken Gyro",
            "",
            9.25,
            false
        ),
        FoodItem(
            "1-3",
            "1",
            "Lamb Gyro",
            "",
            9.5,
            false
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_truck_detail, container, false)
        view.findViewById<RecyclerView>(R.id.foodItemsRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = FoodItemListRecyclerViewAdapter(foodItems)
        }
        // TODO: change title bar
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val location: TextView = view.findViewById(R.id.foodTruckDetailLocation)
        val time: TextView = view.findViewById(R.id.foodTruckDetailTime)

        location.text = args.truckLocation
        time.text = args.truckTime
    }

    /*
    private fun updateList() {
        foodTruckService.listFoodItems().enqueue(object : Callback<List<FoodItem>> {
            override fun onResponse(
                call: Call<List<FoodItem>>,
                response: Response<List<FoodItem>>
            ) {
                TODO("Change recycler view")
            }

            override fun onFailure(call: Call<List<FoodItem>>, t: Throwable) {
                throw t
            }
        })
    }
     */
}