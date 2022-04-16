package com.example.week6.fragment

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week6.R
import com.example.week6.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: MovieAdapter

    private var isLinearLayoutManager = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.get_now_playing -> viewModel.getNowPlaying()
                R.id.get_top_rated -> viewModel.getTopRateMovie()
            }
            true
        }

        chooseLayout()
        setUpMovieList()
        registerMovieList()
    }


    override fun onStart() {
        super.onStart()
        viewModel.getNowPlaying()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu_option, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    // ========================== functions ===========================

    private fun setUpMovieList() {
        adapter = MovieAdapter()
        binding.rvMovies.layoutManager = LinearLayoutManager(context)
        binding.rvMovies.adapter = adapter
    }

    private fun registerMovieList() {
        viewModel.movieData.observe(this) {
            adapter.submitList(it)
        }
    }


    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            binding.rvMovies.layoutManager = LinearLayoutManager(this@HomeFragment.requireContext())
        } else {
            binding.rvMovies.layoutManager = GridLayoutManager(this@HomeFragment.requireContext(), 2)
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this@HomeFragment.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this@HomeFragment.requireContext(), R.drawable.ic_linear_layout)
    }



}