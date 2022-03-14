package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}