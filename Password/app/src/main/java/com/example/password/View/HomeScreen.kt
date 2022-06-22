package com.example.password.View

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.password.R
import com.example.password.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment() {

    private lateinit var homeBind : FragmentHomeScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBind = FragmentHomeScreenBinding.inflate(inflater,container,false)
        return homeBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBind.sivKeyIconContainer.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreen_to_password)
        }

        homeBind.sivRandomPassIconContainer.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreen_to_randomPasswordGenerate)
        }

        homeBind.sivSettingIconContainer.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreen_to_setting)
        }

        homeBind.sivSyncIconContainer.setOnClickListener{
            Toast.makeText(context, "¯\\_(ツ)_/¯\nThis function might be implemented soon", Toast.LENGTH_SHORT).show()
        }
    }
}