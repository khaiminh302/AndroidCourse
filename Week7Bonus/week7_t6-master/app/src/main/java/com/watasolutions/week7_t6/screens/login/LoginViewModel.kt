package com.watasolutions.week7_t6.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.watasolutions.week7_t6.database.User
import com.watasolutions.week7_t6.database.UserDatabase
import com.watasolutions.week7_t6.database.UserRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : UserRepository
    private var _saveEventSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val saveEventSuccess: LiveData<Boolean>
        get() = _saveEventSuccess

    private lateinit var readAllData : List<User>


    init{
        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDAO)
        viewModelScope.launch(Dispatchers.IO) {
            readAllData = repository.repoLoadUsersList()
        }
    }


    fun addUser(user : User) {
        if (user.username == "" || user.password =="")
            return

        viewModelScope.launch(Dispatchers.IO) {
            repository.repoAddUser(user)
        }
        _saveEventSuccess.value = true
    }


    fun loadUsersList() : List<User>{
        viewModelScope.launch(Dispatchers.IO) {
            readAllData = repository.repoLoadUsersList()
        }
        return readAllData
    }

}