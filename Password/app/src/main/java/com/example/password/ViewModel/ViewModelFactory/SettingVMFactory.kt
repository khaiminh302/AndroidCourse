package com.example.password.ViewModel.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.password.ViewModel.SettingVM
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import java.lang.IllegalArgumentException

class SettingVMFactory (private val settingAppdata : Appdata): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SettingVM::class.java)){
            val settingRepos = settingAppdata.accountRepos
            return SettingVM(settingRepos) as T
        }
        throw IllegalArgumentException ("Unknown")
    }
}