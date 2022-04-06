package com.example.week5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5.viewmodel.HomeRestaurantViewModel
import com.example.week5.R
import com.example.week5.RestaurantAdapter
import com.example.week5.databinding.ActivityRestaurantBinding


class ListRestaurantActivity: AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding
    lateinit var viewModel: HomeRestaurantViewModel
    lateinit var adapter: RestaurantAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(HomeRestaurantViewModel::class.java)


        adapter = RestaurantAdapter()
        binding.rvRestaurant.adapter = adapter


        // default linear layout
        binding.rvRestaurant.layoutManager = LinearLayoutManager(this)


        binding.btnLayoutLinear.setOnClickListener {
            val layoutManager = LinearLayoutManager(this)
            binding.rvRestaurant.layoutManager = layoutManager
            binding.rvRestaurant.adapter = adapter
        }

        binding.btnLayoutGrid.setOnClickListener {
            val layoutManager = GridLayoutManager(this, 2)
            binding.rvRestaurant.layoutManager = layoutManager
            binding.rvRestaurant.adapter = adapter
        }


        registerDatasetListener()

    }

    override fun onStart() {
        super.onStart()
        viewModel.getData()

    }

    private fun  registerDatasetListener() {
        viewModel.listOfRestaurant.observe(this) { dataSet ->
            adapter.submitList(dataSet)
        }
    }

}
