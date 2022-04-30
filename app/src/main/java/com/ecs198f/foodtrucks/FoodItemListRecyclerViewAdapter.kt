package com.ecs198f.foodtrucks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecs198f.foodtrucks.databinding.FoodItemListItemBinding

class FoodItemListRecyclerViewAdapter(private var items: List<FoodItem>) :
    RecyclerView.Adapter<FoodItemListRecyclerViewAdapter.ViewHolder>() {

    fun updateList(items: List<FoodItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FoodItemListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FoodItemListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].let {
            holder.binding.apply {
                foodItemListItemName.text = it.name
                foodItemListItemDescription.text = it.description
                val priceString = "\$" + it.price.toString()
                foodItemListItemPrice.text = priceString
                var taxIncludedString = "(tax included)"
                if (!it.taxIncluded) {
                    taxIncludedString = "(tax not included)"
                }
                foodItemListItemTaxIncluded.text = taxIncludedString
            }
        }
    }

    override fun getItemCount() = items.size
}