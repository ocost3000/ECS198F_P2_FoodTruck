package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class FoodItemListRecyclerViewAdapter(private val foodItems: List<FoodItem>) :
    RecyclerView.Adapter<FoodItemListRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.itemName)
        val itemDesc: TextView = itemView.findViewById(R.id.itemDesc)
        val itemPrice: TextView = itemView.findViewById(R.id.itemPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = foodItems[position]

        holder.apply {
            itemTitle.text = item.name
            itemDesc.text = item.description
            itemPrice.text = item.formattedPrice
        }
    }

    override fun getItemCount() = foodItems.size
}