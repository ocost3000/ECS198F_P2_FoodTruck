package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class FoodTruckListRecyclerViewAdapter(private var foodTrucks: List<FoodTruck>) :
    RecyclerView.Adapter<FoodTruckListRecyclerViewAdapter.ViewHolder>() {

    // Web Update
    /*
    fun updateFoodTrucks(foodTrucks: List<FoodTruck>) {
        this.foodTrucks = foodTrucks
        notifyDataSetChanged()
    }

     */

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val truckTitle: TextView = itemView.findViewById(R.id.foodTruckListItemTitle)
        val truckImage: ImageView = itemView.findViewById(R.id.foodTruckListItemImage)
        val truckLocation: TextView = itemView.findViewById(R.id.foodTruckListItemLocation)
        val truckTime: TextView = itemView.findViewById(R.id.foodTruckListItemTime)
        val truckPricePoint: TextView = itemView.findViewById(R.id.foodTruckListItemPriceLevel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.food_truck_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val truck = foodTrucks[position]

        holder.apply {
            truckTitle.text = truck.name
            truckLocation.text = truck.location
            truckTime.text = truck.formattedTimeInterval
            truckPricePoint.text = "$".repeat(truck.priceLevel)
            truckImage.setImageResource(R.drawable.hefty_gyros)

            /*
            Glide.with(this.itemView)
                .load(truck.imageUrl)
                .into(truckImage)

             */
        }

        holder.itemView.setOnClickListener {
            // navigate to details page
            val action = FoodTruckListFragmentDirections.actionFoodTruckListFragmentToFoodTruckDetailFragment()
            action.truckName = truck.name
            action.truckLocation = truck.location
            action.truckTime = truck.formattedTimeInterval
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = foodTrucks.size
}