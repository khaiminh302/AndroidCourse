package com.example.week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week5.data.DataStoreAccount
import com.example.week5.databinding.FragmentProfileBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountInfoToLayout()

        binding.btnLogout.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_profileFragment_to_welcomeFragment)
        }

    }

    private fun accountInfoToLayout() {
        binding.tvFullNameProfile.text = DataStoreAccount.getAccountInfo().name
        binding.tvEmailProfile.text = DataStoreAccount.getAccountInfo().email
        binding.tvPhoneProfile.text = DataStoreAccount.getAccountInfo().phone
        binding.tvUserName.text = binding.tvFullNameProfile.text
    }

}