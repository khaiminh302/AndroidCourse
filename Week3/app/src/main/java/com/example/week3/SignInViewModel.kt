package com.example.week3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel: ViewModel() {

    private var _errorSignInLiveData: MutableLiveData<String> = MutableLiveData()
    val errorSignInLiveData: LiveData<String>
        get() = _errorSignInLiveData

    private var _successSignInLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successSignInLiveData: LiveData<Boolean>
        get() = _successSignInLiveData



    fun isSignInSuccess(user: User?, email: String, password: String) {
        _successSignInLiveData.postValue(false)
        _errorSignInLiveData.postValue(null)

        if (email != user?.email) {
            _errorSignInLiveData.postValue("Email không tồn tại")
            return
        }

        if (password != user?.password) {
            _errorSignInLiveData.postValue("Password không đúng")
            return
        }

        return _successSignInLiveData.postValue(true)
    }

}