package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvEditProfile: TextView = findViewById(R.id.edit_profile_text)

        val tvName: TextView = findViewById(R.id.textView_profile_full_name)
        tvName.text = findViewById<TextView>(R.id.user_name).text

        val tvEmail: TextView = findViewById(R.id.textView_profile_email)
        tvEmail.text = "ronaldo@gmail.com"

        val tvPhone: TextView = findViewById(R.id.textView_profile_phone)

        tvEditProfile.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_profile, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
            val editProfileDialog = mBuilder.show()

            val editTextName = mDialogView.findViewById<EditText>(R.id.editText_name)
            val editTextEmail = mDialogView.findViewById<EditText>(R.id.editText_email)
            val editTextPhone = mDialogView.findViewById<EditText>(R.id.editText_phone)

            // get current info to dialog editTextView
            editTextName.setText(tvName.text)
            editTextEmail.setText(tvEmail.text)
            editTextPhone.setText(tvPhone.text)

            mDialogView.findViewById<Button>(R.id.button_okay).setOnClickListener{
                if (editTextName.text.toString() == "" || editTextEmail.text.toString() == "" || editTextPhone.text.toString() == "") {
                    Log.e("DIALOG", "Edit is empty")
                    Toast.makeText(this, "All field must not be empty", Toast.LENGTH_SHORT).show()
                } else {
                    tvName.text = editTextName.text.toString().trim()
                    findViewById<TextView>(R.id.user_name).text = tvName.text

                    tvEmail.text = editTextEmail.text.toString().trim()
                    tvPhone.text = editTextPhone.text.toString().trim()
                    editProfileDialog.dismiss()
                }
            }

            mDialogView.findViewById<Button>(R.id.button_cancel).setOnClickListener{
                editProfileDialog.dismiss()
            }
        }




    }




}