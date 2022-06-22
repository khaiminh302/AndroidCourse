package com.example.password.ViewModel

import android.app.Application
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.*
import com.example.password.Model.DataProcessor
import com.example.password.Model.Room.AccountDefine
import com.example.password.Model.Room.Repository.AccountRepository
import kotlinx.coroutines.launch

class EnterAccountVM(private val accountRepository: AccountRepository) : ViewModel() {
    private val STATE_BEFORE_ADD_NEW_ACCOUNT = false
    private val STATE_BEFORE_CHECKING = false

    private lateinit var  listOfAccount : List<AccountDefine>

    var _modeOnEvent : MutableLiveData<Boolean> = MutableLiveData()
    val modeOnEvent : LiveData<Boolean>
    get() = _modeOnEvent

    var _successEvent : MutableLiveData<Boolean> = MutableLiveData()
    val successEvenet : LiveData<Boolean>
        get() = _successEvent

    var _errorEvent : MutableLiveData<String> = MutableLiveData()
    val errorEvent : LiveData<String>
        get() = _errorEvent

    var _detectEvent : MutableLiveData<String> = MutableLiveData()
    val detectEvent : LiveData<String>
    get() = _detectEvent

    var _notDetectEvent : MutableLiveData<Boolean> = MutableLiveData()
    val notDetectEvent : LiveData<Boolean>
    get() = _notDetectEvent


    fun registerNewAccount( email: String, password: String, note: String, logo: Int) {

        var isEmailValid = DataProcessor.isEmailValid(email)

        //_successEvent.postValue(STATE_BEFORE_ADD_NEW_ACCOUNT) // To reset state

        if (isEmailValid) {
            addNewAccount(note, email, password, logo)
            _successEvent.postValue(true)
        }else{
            _errorEvent.postValue("Nhap sai email, vui long nhap lai")
        }
    }

    fun addNewAccount(note: String, email: String, password: String, logo: Int){
        viewModelScope.launch {
            accountRepository.addNewAccount(
                note = note,
                email = email,
                password = password,
                logo = logo)
        }
    }

    suspend fun getListOfAccountFromDataBase() : List<AccountDefine>{
            listOfAccount = accountRepository.getListAccount()
        return  listOfAccount
    }

    fun isPasswordAppearFreq(password : String){
        _notDetectEvent.postValue(STATE_BEFORE_CHECKING)

        viewModelScope.launch {
            if(DataProcessor.isPasswordAppearManyTime(password, getListOfAccountFromDataBase())){
                _detectEvent.postValue("Your password appear too much times, think about using new password next time !")
            }else{
                _notDetectEvent.postValue(true)
            }
        }
    }

    fun isSecurityPasswordModeOn(){
        _modeOnEvent.postValue(false)
        if(DataProcessor.isSecurityModeOn){
            _modeOnEvent.postValue(true)
        }
    }
}