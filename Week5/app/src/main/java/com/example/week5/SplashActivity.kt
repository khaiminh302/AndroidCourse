package com.example.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        startActivity(Intent(this@SplashActivity, Onboarding_1_Activity::class.java))
//        startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))


        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}