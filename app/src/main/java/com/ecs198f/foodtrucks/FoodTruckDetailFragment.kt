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

class FoodTruckDetailFragment : Fragment() {
    // handle arguments specified in nav_graph
    private val args: FoodTruckDetailFragmentArgs by navArgs()


    /* Boilerplate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
     */

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

    /* Boilerplate
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FoodTruckDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FoodTruckDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */
}