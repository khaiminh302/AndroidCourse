package com.example.week3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {

    private var _errorSignUpLiveData: MutableLiveData<String> = MutableLiveData()
    val errorSignUpLiveData: LiveData<String>
        get() = _errorSignUpLiveData

    private var _successSignUpLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successSignUpLiveData: LiveData<Boolean>
        get() = _successSignUpLiveData


    // -------
    fun isSignUpValid(name: String, email: String, password: String) {

        val isNameValid = Validator.isNameValid(name)
        val isEmailValid = Validator.isEmailValid(email)
        val isPasswordValid = Validator.isPasswordValid(password)

        _successSignUpLiveData.postValue(false)

        if (!isNameValid) {
            _errorSignUpLiveData.postValue("Full name không hợp lệ")
            return
        }

        if (!isEmailValid) {
            _errorSignUpLiveData.postValue("Email không hợp lệ")
            return
        }

        if (!isPasswordValid) {
            _errorSignUpLiveData.postValue("Password không hợp lệ")
            return
        }

        return _successSignUpLiveData.postValue(true)
    }
}