package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("WELCOME", "onCreate")
        setContentView(R.layout.activity_welcome)

        val start_sign_up = findViewById<Button>(R.id.start_w_mail_phone)
        start_sign_up.setOnClickListener {
            val intent = Intent (this@WelcomeActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        val sign_in = findViewById<TextView>(R.id.sign_in)
        sign_in.setOnClickListener {
            val intent = Intent (this@WelcomeActivity, SignInActivity::class.java)
            startActivity(intent)
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