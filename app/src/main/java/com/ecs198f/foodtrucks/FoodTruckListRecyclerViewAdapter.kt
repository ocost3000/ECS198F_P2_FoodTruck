package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodTruckListRecyclerViewAdapter(private val foodTrucks: List<FoodTruck>) :
    RecyclerView.Adapter<FoodTruckListRecyclerViewAdapter.ViewHolder>() {

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
            truckImage.setImageResource(truck.imageResId)
            truckLocation.text = truck.location
            truckTime.text = truck.formattedTimeInterval
            truckPricePoint.text = "$".repeat(truck.priceLevel)
        }

        /* Obsolete intent stuff
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, FoodTruckDetail::class.java)
            intent.putExtra("FoodTruck", truck)
            it.context.startActivity(intent)
        }
         */
    }

    override fun getItemCount() = foodTrucks.size
}