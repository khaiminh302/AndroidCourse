package com.example.password.View.Password

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.password.Model.DataProcessor
import com.example.password.R
import com.example.password.ViewModel.EditAccountVM
import com.example.password.ViewModel.ViewModelFactory.EditPassVMFactory
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import com.example.password.databinding.FragmentEditPasswordBinding


class EditPassword : Fragment() {

    private lateinit var editBind : FragmentEditPasswordBinding
    private lateinit var editVM : EditAccountVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editBind = FragmentEditPasswordBinding.inflate(inflater,container,false)
        editVM = ViewModelProvider(this, EditPassVMFactory(context?.applicationContext as Appdata))[EditAccountVM::class.java]
        return editBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountToChange = editVM.accountClicked()

        val noteInput   = editBind.edtNote
        val emailInput  = editBind.edtEmail
        val passwordInput   = editBind.edtPassword
        val logoInput      = editBind.sivAccountLogo

        noteInput.setText(accountToChange?.note.toString())
        emailInput.setText(accountToChange?.email.toString())
        passwordInput.setText(accountToChange?.password.toString())

        logoInput.setBackgroundResource(accountToChange?.logo!!)

        editBind.btnSaveEdit.setOnClickListener {
            val note = noteInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            editVM.saveAccountEdit(note, email, password)
            insteadOfNavigation()
        }

        editBind.btnDelete.setOnClickListener {
            editVM.deleteThatAccount()
            insteadOfNavigation()
        }
    }

    fun insteadOfNavigation(){
        activity?.supportFragmentManager?.popBackStack() // Because we navigate to that fragment without using the navHostController so it will create a new back stack, therefore we have to come back by using popStack
    }
}