package com.example.week5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.week5.R
import com.example.week5.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("WELCOME", "onCreate")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        binding.btnStartWMailPhone.setOnClickListener {
            startActivity( Intent(this@WelcomeActivity, SignUpActivity::class.java))
        }

        binding.tvSignIn.setOnClickListener {
            startActivity( Intent(this@WelcomeActivity, SignInActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("WELCOME", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("WELCOME", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("WELCOME", "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.e("WELCOME", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("WELCOME", "onStop")
    }
}