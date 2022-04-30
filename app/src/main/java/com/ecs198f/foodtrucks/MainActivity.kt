package com.ecs198f.foodtrucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ecs198f.foodtrucks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Food Trucks"
    }
}