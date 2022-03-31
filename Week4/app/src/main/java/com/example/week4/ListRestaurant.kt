package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week4.databinding.ActivityRestaurantBinding


class ListRestaurant: AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding
    lateinit var viewModel: ListRestaurantViewModel
    lateinit var adapter: RestaurantAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(ListRestaurantViewModel::class.java)


        adapter = RestaurantAdapter()


        val layoutManager = LinearLayoutManager(this)
        binding.rvRestaurant.layoutManager = layoutManager
        binding.rvRestaurant.adapter = adapter


        binding.layoutbutton.setOnClickListener {
            val layoutManager = LinearLayoutManager(this)
            binding.rvRestaurant.layoutManager = layoutManager
            binding.rvRestaurant.adapter = adapter
        }

        binding.layoutbutton1.setOnClickListener {
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
