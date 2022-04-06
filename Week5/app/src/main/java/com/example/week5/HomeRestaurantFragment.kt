package com.example.week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week5.databinding.FragmentHomeRestaurantBinding
import com.example.week5.viewmodel.HomeRestaurantViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeRestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeRestaurantFragment : Fragment() {

    lateinit var binding: FragmentHomeRestaurantBinding
    lateinit var viewModel: HomeRestaurantViewModel
    lateinit var adapter: RestaurantAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeRestaurantViewModel::class.java)

        adapter = RestaurantAdapter()
        binding.rvRestaurant.adapter = adapter

        // default linear layout
        binding.rvRestaurant.layoutManager = LinearLayoutManager(this@HomeRestaurantFragment.requireContext())

        // switch layout button
        binding.btnLayoutLinear.setOnClickListener {
            val layoutManager = LinearLayoutManager(this@HomeRestaurantFragment.requireContext())
            binding.rvRestaurant.layoutManager = layoutManager
            binding.rvRestaurant.adapter = adapter
        }

        binding.btnLayoutGrid.setOnClickListener {
            val layoutManager = GridLayoutManager(this@HomeRestaurantFragment.requireContext(), 2)
            binding.rvRestaurant.layoutManager = layoutManager
            binding.rvRestaurant.adapter = adapter
        }


        // button to profile
        binding.btnProfile.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_homeRestaurantFragment_to_profileFragment)
        }

        registerDatasetListener()

    }

    override fun onStart() {
        super.onStart()
        viewModel.getData()

    }

    private fun  registerDatasetListener() {
        viewModel.listOfRestaurant.observe(viewLifecycleOwner) { dataSet ->
            adapter.submitList(dataSet)
        }
    }

}