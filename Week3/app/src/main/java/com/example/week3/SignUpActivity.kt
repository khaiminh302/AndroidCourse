package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener {
            val intent = Intent (this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}