package com.example.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Onboarding_1_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_1)

        val nextButton = findViewById<ImageButton>(R.id.btn_next_1)
        nextButton.setOnClickListener {
            val intent = Intent (this@Onboarding_1_Activity, Onboarding_2_Activity::class.java)
            startActivity(intent)
        }


    }
}