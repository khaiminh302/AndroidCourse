package com.example.week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week5.databinding.FragmentOnboarding3Binding

/**
 * A simple [Fragment] subclass.
 * Use the [Onboarding_3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Onboarding_3Fragment : Fragment() {

    lateinit var binding: FragmentOnboarding3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboarding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext3.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_onboarding_3Fragment_to_welcomeFragment)
        }
    }

}