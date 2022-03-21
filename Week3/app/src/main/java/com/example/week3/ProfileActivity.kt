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

        val tvEditProfile: TextView = findViewById(R.id.tv_edit_profile)

        val tvName: TextView = findViewById(R.id.tv_full_name_profile)
        tvName.text = findViewById<TextView>(R.id.tv_user_name).text

        val tvEmail: TextView = findViewById(R.id.tv_email_profile)
        tvEmail.text = "ronaldo@gmail.com"

        val tvPhone: TextView = findViewById(R.id.tv_phone_profile)

        tvEditProfile.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_profile, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
            val editProfileDialog = mBuilder.show()

            val editTextName = mDialogView.findViewById<EditText>(R.id.edt_dialog_name)
            val editTextEmail = mDialogView.findViewById<EditText>(R.id.edt_dialog_email)
            val editTextPhone = mDialogView.findViewById<EditText>(R.id.edt_dialog_phone)

            // get current info to dialog editTextView
            editTextName.setText(tvName.text)
            editTextEmail.setText(tvEmail.text)
            editTextPhone.setText(tvPhone.text)

            mDialogView.findViewById<Button>(R.id.btn_okay).setOnClickListener{
                if (editTextName.text.toString() == "" || editTextEmail.text.toString() == "" || editTextPhone.text.toString() == "") {
                    Log.e("DIALOG", "Edit is empty")
                    Toast.makeText(this, "All field must not be empty", Toast.LENGTH_SHORT).show()
                } else {
                    tvName.text = editTextName.text.toString().trim()
                    findViewById<TextView>(R.id.tv_user_name).text = tvName.text

                    tvEmail.text = editTextEmail.text.toString().trim()
                    tvPhone.text = editTextPhone.text.toString().trim()
                    editProfileDialog.dismiss()
                }
            }

            mDialogView.findViewById<Button>(R.id.btn_cancel).setOnClickListener{
                editProfileDialog.dismiss()
            }
        }




    }




}