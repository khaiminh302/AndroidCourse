package com.example.password.ViewModel

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.*
import com.example.password.Model.Room.AccountDatabase
import com.example.password.Model.Room.AccountDefine
import com.example.password.Model.Room.Repository.AccountRepository
import kotlinx.coroutines.launch

class PasswordVM(private val accountRepository: AccountRepository) : ViewModel() {


    var _loadData : MutableLiveData<List<AccountDefine>> = MutableLiveData()
    val loadData : LiveData<List<AccountDefine>>
        get() = _loadData

    private lateinit var listOfAccount : List<AccountDefine>


    fun getListOfAccountFromDataBase(){
        viewModelScope.launch {
            listOfAccount = accountRepository.getListAccount()
            _loadData.postValue(listOfAccount)
        }

    }
}