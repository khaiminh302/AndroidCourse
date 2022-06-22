package com.example.password.ViewModel.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.password.ViewModel.EditAccountVM
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import java.lang.IllegalArgumentException

class EditPassVMFactory(private val editAccountAppData: Appdata) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EditAccountVM::class.java)){
            val editAccountRepos = editAccountAppData.accountRepos
            return EditAccountVM(editAccountRepos) as T
        }
        throw IllegalArgumentException ("Unknown")
    }
}