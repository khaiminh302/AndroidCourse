package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)


        // Sign up button clicked
        binding.btnSignUp.setOnClickListener {
            val signUpName = binding.edtFullName.text.toString().trim()
            val signUpEmail = binding.edtEmail.text.toString().trim()
            val signUpPassword = binding.edtPassword.text.toString().trim()

            viewModel.isSignUpValid(signUpName, signUpEmail, signUpPassword)
        }

        listenSignUpError()
        listenSignUpSuccess()


        // Login (Sign in) textView clicked
        binding.tvLogin .setOnClickListener {
            startActivity( Intent(this@SignUpActivity, SignInActivity::class.java))
        }

    }

    // Listener for live data events
    private fun listenSignUpSuccess() {
        viewModel.successSignUpLiveData.observe(this) {
            if (it) {
                Toast.makeText(this, "Sign up thành công", Toast.LENGTH_SHORT).show()

                DataStore.createAccount(
                    binding.edtFullName.text.toString().trim(),
                    binding.edtEmail.text.toString().trim(),
                    binding.edtPassword.text.toString().trim()
                )

                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun listenSignUpError() {
        viewModel.errorSignUpLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }




}