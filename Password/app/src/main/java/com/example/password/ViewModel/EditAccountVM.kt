package com.example.password.ViewModel

import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.password.Model.DataProcessor
import com.example.password.Model.Room.AccountDefine
import com.example.password.Model.Room.Repository.AccountRepository
import kotlinx.coroutines.launch

class EditAccountVM( private val accountRepos : AccountRepository) : ViewModel() {

    fun deleteThatAccount(){
        viewModelScope.launch {
            accountRepos.deletaAccount(DataProcessor.accountInfo!!)
        }
    }

    fun accountClicked() : AccountDefine?{
        return DataProcessor.accountInfo
    }

    fun saveAccountEdit(note: String, email: String, password: String){
        viewModelScope.launch {
            val info = DataProcessor.accountInfo
            accountRepos.updateAccount(note, password, email, info!!.uid)
        }
    }
}