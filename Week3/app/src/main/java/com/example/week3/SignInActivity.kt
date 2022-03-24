package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)

        val bundle = intent.extras

        binding.imbtnBack.setOnClickListener {
            finish()
        }

        binding.btnSignIn.setOnClickListener {
            bundle?.let {
                val user = it.getParcelable(Constants.KEY_USER) as? User
                val loginMail = binding.edtEmailSignIn.text.toString().trim()
                val loginPassword = binding.edtPasswordSignIn.text.toString().trim()

                viewModel.isSignInSuccess(user, loginMail, loginPassword)
            }
        }

        listenSignInSuccess(bundle)
        listenSignInError()


    }

    private fun listenSignInSuccess(bundle: Bundle?) {
        viewModel.successSignInLiveData.observe(this) {
            if (it) {
                Toast.makeText(this, "Sign in thành công", Toast.LENGTH_SHORT).show()

                bundle?.let {
                    val intent = Intent(this, ProfileActivity::class.java)
                    val bundleToProfile = Bundle()

                    val user = it.getParcelable(Constants.KEY_USER) as? User

                    bundleToProfile.putParcelable(
                        Constants.KEY_USER,
                        User(user?.name.toString(), user?.email.toString(), user?.password.toString())
                    )
                    intent.putExtras(bundleToProfile)
                    startActivity(intent)
                }
            }
        }
    }


    private fun listenSignInError() {
        viewModel.errorSignInLiveData.observe(this) {
            if (it != null) { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        }
    }

}