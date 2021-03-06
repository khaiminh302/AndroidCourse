package com.example.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.e("SIGN-IN", "onCreate")

        val sign_in_back_button = findViewById<ImageButton>(R.id.sign_in_back_button)
        sign_in_back_button.setOnClickListener {
            finish()
        }

        val login_mail = findViewById<EditText>(R.id.editTextTextEmailAddress_login)
        val login_password = findViewById<EditText>(R.id.editTextTextPassword_login)
        val login_button = findViewById<Button>(R.id.login_button)


        login_button.setOnClickListener {
            if (login_mail.text.toString().trim() == "ronaldo@gmail.com" && login_password.text.toString().trim() == "123456") {
                Toast.makeText(this@SignInActivity, "Login successfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@SignInActivity, ProfileActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Constants.KEY_MAIL, login_mail.text.toString().trim())
                bundle.putString(Constants.KEY_PASSWORD, login_password.text.toString().trim())
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(this@SignInActivity, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }



    }


    override fun onStart() {
        super.onStart()
        Log.e("SIGN-IN", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SIGN-IN", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SIGN-IN", "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SIGN-IN", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SIGN-IN", "onStop")
    }
}