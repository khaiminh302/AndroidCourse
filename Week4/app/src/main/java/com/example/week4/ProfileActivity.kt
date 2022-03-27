package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.week4.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        accountInfoToLayout()

        binding.tvEditProfile.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_profile, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
            val editProfileDialog = mBuilder.show()

            val editTextName = mDialogView.findViewById<EditText>(R.id.edt_dialog_name)
            val editTextEmail = mDialogView.findViewById<EditText>(R.id.edt_dialog_email)
            val editTextPhone = mDialogView.findViewById<EditText>(R.id.edt_dialog_phone)

            // get current info to dialog editTextView
            editTextName.setText(binding.tvFullNameProfile.text)
            editTextEmail.setText(binding.tvEmailProfile.text)
            editTextPhone.setText( binding.tvPhoneProfile.text)

            mDialogView.findViewById<Button>(R.id.btn_okay).setOnClickListener{
                if (editTextName.text.toString() == "" || editTextEmail.text.toString() == "" || editTextPhone.text.toString() == "") {
                    Toast.makeText(this, "All field must not be empty", Toast.LENGTH_SHORT).show()

                } else {

                    DataStore.editAccount(
                        editTextName.text.toString().trim(),
                        editTextEmail.text.toString().trim(),
                        editTextEmail.text.toString().trim(),
                        editTextPhone.text.toString().trim()
                    )
                    accountInfoToLayout()

                    editProfileDialog.dismiss()
                }
            }

            mDialogView.findViewById<Button>(R.id.btn_cancel).setOnClickListener{
                editProfileDialog.dismiss()
            }
        }




    }

    private fun accountInfoToLayout() {
        binding.tvFullNameProfile.text = DataStore.getAccountInfo().name
        binding.tvEmailProfile.text = DataStore.getAccountInfo().email
        binding.tvPhoneProfile.text = DataStore.getAccountInfo().phone
        binding.tvUserName.text = binding.tvFullNameProfile.text
    }




}