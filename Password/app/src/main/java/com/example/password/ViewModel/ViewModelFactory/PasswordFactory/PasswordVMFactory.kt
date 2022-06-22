package com.example.password.ViewModel.ViewModelFactory.PasswordFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.password.ViewModel.PasswordVM
import java.lang.IllegalArgumentException

class PasswordVMFactory(private val appData: Appdata) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PasswordVM::class.java)){
            val passwordRepos = appData.accountRepos
            return PasswordVM(passwordRepos) as T
        }
        throw IllegalArgumentException ("Unknown")
    }
}