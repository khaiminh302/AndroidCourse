package com.example.week5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week5.data.DataStoreAccount

class SignInViewModel: ViewModel() {

    private var _errorSignInLiveData: MutableLiveData<String> = MutableLiveData()
    val errorSignInLiveData: LiveData<String>
        get() = _errorSignInLiveData

    private var _successSignInLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successSignInLiveData: LiveData<Boolean>
        get() = _successSignInLiveData



    fun isSignInSuccess(email: String, password: String) {
        _successSignInLiveData.postValue(false)
        _errorSignInLiveData.postValue(null)

        if (email != DataStoreAccount.getAccountInfo().email) {
            _errorSignInLiveData.postValue("Email không tồn tại")
            return
        }

        if (password != DataStoreAccount.getAccountInfo().password) {
            _errorSignInLiveData.postValue("Password không đúng")
            return
        }

        return _successSignInLiveData.postValue(true)
    }

}