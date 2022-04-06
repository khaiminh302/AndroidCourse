package com.example.week5

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week5.databinding.FragmentSignInBinding
import com.example.week5.viewmodel.SignInViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : Fragment() {
    lateinit var binding: FragmentSignInBinding
    lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        binding.btnSignIn.setOnClickListener {
            val loginMail = binding.edtEmailSignIn.text.toString().trim()
            val loginPassword = binding.edtPasswordSignIn.text.toString().trim()

            viewModel.isSignInSuccess(loginMail, loginPassword)
        }

        listenSignInSuccess()
        listenSignInError()
    }



    private fun listenSignInSuccess() {
        viewModel.successSignInLiveData.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(this@SignInFragment.requireContext(), "Sign in thành công", Toast.LENGTH_SHORT).show()

                val controller = findNavController()
                controller.navigate(R.id.action_signInFragment_to_homeRestaurantFragment)
            }
        }
    }


    private fun listenSignInError() {
        viewModel.errorSignInLiveData.observe(viewLifecycleOwner) {
            if (it != null) { Toast.makeText(this@SignInFragment.requireContext(), it, Toast.LENGTH_SHORT).show() }
        }
    }

}