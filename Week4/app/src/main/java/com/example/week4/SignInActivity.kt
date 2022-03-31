package com.example.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week4.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
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
        viewModel.successSignInLiveData.observe(this) {
            if (it) {
                Toast.makeText(this, "Sign in thành công", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ListRestaurant::class.java)
                startActivity(intent)

            }
        }
    }


    private fun listenSignInError() {
        viewModel.errorSignInLiveData.observe(this) {
            if (it != null) { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        }
    }

}