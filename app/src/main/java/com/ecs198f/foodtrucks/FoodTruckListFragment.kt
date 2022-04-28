package com.ecs198f.foodtrucks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ecs198f.foodtrucks.databinding.FragmentFoodTruckListBinding

class FoodTruckListFragment : Fragment() {
    private var _binding: FragmentFoodTruckListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodTruckListBinding.inflate(inflater, container, false)
        val view = binding.root

        // TODO check if this implementation of fragment binding to recycler view works
        /*
        _binding.foodTruckListRecyclerView.apply {

        }

         */
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}