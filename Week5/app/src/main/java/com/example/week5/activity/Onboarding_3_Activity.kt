package com.example.week5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.week5.R

class Onboarding_3_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_3)

        val nextButton = findViewById<ImageButton>(R.id.btn_next_3)
        nextButton.setOnClickListener {
            val intent = Intent (this@Onboarding_3_Activity, WelcomeActivity::class.java)
            startActivity(intent)
        }

    }
}