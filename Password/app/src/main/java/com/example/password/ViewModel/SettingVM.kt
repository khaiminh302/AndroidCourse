package com.example.password.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.password.Model.DataProcessor
import com.example.password.Model.Room.Repository.AccountRepository
import kotlinx.coroutines.launch

class SettingVM(private val settingRepos : AccountRepository) : ViewModel() {

    var _setEvent : MutableLiveData<Boolean> = MutableLiveData()
    val setEvent : LiveData<Boolean>
    get() = _setEvent

    fun setTheSecurityMode(isSecurityModeOn : Boolean){
        DataProcessor.isSecurityModeOn = isSecurityModeOn
    }

    fun switchInitial(){
        _setEvent.postValue(false)
        if(DataProcessor.isSecurityModeOn){
            _setEvent.postValue(true)
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            settingRepos.deleteAll()
        }
    }
}