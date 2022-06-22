package com.example.password.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.password.Model.DataProcessor
import com.example.password.Model.masterkeySharedStore

class EnterAppViewModel: ViewModel() {

    val STATE_BEFORE_LOGIN = false

    var _successEvenet : MutableLiveData<Boolean> = MutableLiveData()
    val successEvent : LiveData<Boolean>
    get() = _successEvenet

    var _errorEvent : MutableLiveData<String> = MutableLiveData()
    val errorEvent : LiveData<String>
    get() = _errorEvent



    fun createMasterKey(context: Context, masterkey: String) {
        _successEvenet.postValue(STATE_BEFORE_LOGIN)

        if(masterkeySharedStore.isMasterKeyValid(masterkey)) {
            masterkeySharedStore.saveMasterKey(context,masterkey)
            _successEvenet.postValue(true)
        }
        else {
            _errorEvent.postValue("Please make sure that you filled all the pin view")
            return
        }
    }



    fun isMasterKeyExist(context: Context): Boolean {
        return masterkeySharedStore.isMasterKeyCreated(context)
    }


    fun checkLogin(masterkey : String, context: Context) {

        val isMasterKeyCorrect = masterkeySharedStore.isMasterKeyCorrect(context,masterkey)
        _successEvenet.postValue(STATE_BEFORE_LOGIN)

        if(!isMasterKeyCorrect && isMasterKeyExist(context)) {
            _errorEvent.postValue("Wrong password PIN")
            return
        }
        else if( isMasterKeyCorrect && isMasterKeyExist(context)) {
            _successEvenet.postValue(true)
            return
        }
    }

}