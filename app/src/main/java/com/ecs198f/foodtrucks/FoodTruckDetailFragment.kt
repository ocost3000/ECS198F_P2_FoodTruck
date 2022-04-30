package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecs198f.foodtrucks.databinding.FragmentFoodTruckDetailBinding
import java.time.LocalDateTime


class FoodTruckDetailFragment : Fragment() {

    private lateinit var binding: FragmentFoodTruckDetailBinding
    private val args: FoodTruckDetailFragmentArgs by navArgs()

    private val foodItems = listOf(
        FoodItem(
            "0-1",
            "2",
            "Sample Item 1",
            "This is a description for Sample Item 1",
            3.99,
            true,
        ),
        FoodItem(
            "0-2",
            "2",
            "Sample Item 2",
            "This is a description for Sample Item 2",
            11.99,
            true,
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFoodTruckDetailBinding.inflate(inflater, container, false)

        val view = binding.root
        val foodTruck = args.foodTruck

        (activity as AppCompatActivity).supportActionBar?.title = foodTruck.name

        binding.apply {
            foodTruckDetailItemPriceLevel.text = "$".repeat(foodTruck.priceLevel)
            foodTruckDetailItemImage.setImageResource(foodTruck.imageResId)
            foodTruckDetailItemLocation.text = foodTruck.location
            foodTruckDetailItemTime.text = foodTruck.formattedTimeInterval
            foodTruckDetailRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = FoodItemListRecyclerViewAdapter(foodItems)
            }
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity).supportActionBar?.title = "Food Trucks"
    }
}