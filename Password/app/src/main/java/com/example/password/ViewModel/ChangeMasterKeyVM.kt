package com.example.password.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.password.Model.masterkeySharedStore

class ChangeMasterKeyVM : ViewModel() {

    var _successEvent : MutableLiveData<Boolean> = MutableLiveData()
    val successEvent : LiveData<Boolean>
    get() = _successEvent



    var _successChange : MutableLiveData<Boolean> = MutableLiveData()
    val successChange : LiveData<Boolean>
    get() = _successChange

    var _errorChange : MutableLiveData<String> = MutableLiveData()
    val errorChange : LiveData<String>
    get() = _errorChange




    fun checkMasterKey(context: Context, masterkey: String)
    {
        _successEvent.postValue(false)
        if(masterkeySharedStore.isMasterKeyCorrect(context,masterkey))
        {
            _successEvent.postValue(true)
        }
        else
        {
            _errorChange.postValue("Re-enter your password")
        }
    }

    fun registerNewMasterKey(context: Context, masterkey: String)
    {
        _successChange.postValue(false)
        if(masterkeySharedStore.isMasterKeyValid(masterkey))
        {
            masterkeySharedStore.saveMasterKey(context,masterkey)
            _successChange.postValue(true)
        }
        else
        {
            _errorChange.postValue("Please make sure that you filled all the pin view")
        }
    }
}