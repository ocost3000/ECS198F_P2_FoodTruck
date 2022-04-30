package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecs198f.foodtrucks.databinding.FoodTruckListItemBinding

class FoodTruckListRecyclerViewAdapter(private var items: List<FoodTruck>) :
    RecyclerView.Adapter<FoodTruckListRecyclerViewAdapter.ViewHolder>() {

    fun updateList(items: List<FoodTruck>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FoodTruckListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodTruckListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].let { foodTruck ->
            holder.binding.apply {
                foodTruckListItemTitle.text = foodTruck.name
                foodTruckListItemPriceLevel.text = "$".repeat(foodTruck.priceLevel)
                Glide.with(holder.itemView).load(foodTruck.imageUrl).into(foodTruckListItemImage)
                foodTruckListItemLocation.text = foodTruck.location
                foodTruckListItemTime.text = foodTruck.formattedTimeInterval
            }

            holder.itemView.setOnClickListener{
                // navigate to details page
                val action = FoodTruckListFragmentDirections.actionFoodTruckListFragmentToFoodTruckDetailFragment(foodTruck)
                it.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount() = items.size
}