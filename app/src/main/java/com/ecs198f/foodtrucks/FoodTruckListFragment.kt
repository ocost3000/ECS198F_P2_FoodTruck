package com.ecs198f.foodtrucks

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class FoodTruckListFragment : Fragment() {


    private val foodTrucks = listOf(
        FoodTruck(
            "1",
            "Shah's Halal",
            "https://android-course-ucd.web.app/img/food-trucks/Shah's_Halal.png",
            3,
            "Silo Patio",
            "2021-10-19T11:00:00",
            "2021-10-19T16:00:00"
        ),
        FoodTruck(
            "2",
            "Hefty Gyros",
            "https://android-course-ucd.web.app/img/food-trucks/Hefty_Gyros.png",
            2,
            "West Quad",
            "2021-10-19T11:00:00",
            "2021-10-19T16:00:00"
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_food_truck_list, container, false)
        view.findViewById<RecyclerView>(R.id.foodTruckListRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = FoodTruckListRecyclerViewAdapter(foodTrucks)
            Log.d(null, "calling updateList()")
            // TODO calling this crashes...
            updateList()

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateList() {
        val foodTruckService = (requireActivity() as MainActivity).foodTruckService
        foodTruckService.listFoodTrucks().enqueue(object: Callback<List<FoodTruck>> {
            override fun onResponse(
                call: Call<List<FoodTruck>>,
                response: Response<List<FoodTruck>>
            ) {
                // just log for now
                Log.d(null, response.body()!!.toString())
                // adapter.updateTrucks(response.body()!!)
            }
            override fun onFailure(call: Call<List<FoodTruck>>, t: Throwable) {
                throw t
            }
        })

    }

}