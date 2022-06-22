package com.example.password.ViewModel.ViewModelFactory.EnterAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.password.ViewModel.EnterAccountVM
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import java.lang.IllegalArgumentException

class EnterAccountVMFactory(private val enterAccountAppData: Appdata) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EnterAccountVM::class.java)){
            val enterAccountRepos = enterAccountAppData.accountRepos
            return EnterAccountVM(enterAccountRepos) as T
        }
        throw IllegalArgumentException ("Unknown")
    }
}