package com.example.week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week5.databinding.FragmentOnboarding2Binding

/**
 * A simple [Fragment] subclass.
 * Use the [Onboarding_2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Onboarding_2Fragment : Fragment() {

    lateinit var binding: FragmentOnboarding2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboarding2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext2.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_onboarding_2Fragment_to_onboarding_3Fragment)
        }
    }


}