package com.example.week5.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.week5.R

class Onboarding_2_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_2)

        val nextButton = findViewById<ImageButton>(R.id.btn_next_2)
        nextButton.setOnClickListener {
            val intent = Intent (this@Onboarding_2_Activity, Onboarding_3_Activity::class.java)
            startActivity(intent)
        }

    }
}