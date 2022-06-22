package com.example.password

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.password.databinding.ActivityMainBinding


class Main : AppCompatActivity() {

    private lateinit var mainBind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mainBind = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}