package com.example.week5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week5.data.DataStoreAccount
import com.example.week5.databinding.FragmentSignUpBinding
import com.example.week5.viewmodel.SignUpViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            val signUpName = binding.edtFullName.text.toString().trim()
            val signUpEmail = binding.edtEmail.text.toString().trim()
            val signUpPassword = binding.edtPassword.text.toString().trim()

            viewModel.isSignUpValid(signUpName, signUpEmail, signUpPassword)
        }

        listenSignUpSuccess()
        listenSignUpError()
    }

    // Listener for live data events
    private fun listenSignUpSuccess() {
        viewModel.successSignUpLiveData.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(this@SignUpFragment.requireContext(), "Sign up thành công", Toast.LENGTH_SHORT).show()

                DataStoreAccount.createAccount(
                    binding.edtFullName.text.toString().trim(),
                    binding.edtEmail.text.toString().trim(),
                    binding.edtPassword.text.toString().trim()
                )

                val controller = findNavController()
                controller.navigate(R.id.action_signUpFragment_to_signInFragment)

            }
        }
    }

    private fun listenSignUpError() {
        viewModel.errorSignUpLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(this@SignUpFragment.requireContext(), it, Toast.LENGTH_SHORT).show()

        }
    }

}