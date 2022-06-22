package com.example.password.ViewModel.ViewModelFactory.PasswordFactory

import android.app.Application
import com.example.password.Model.Room.AccountDatabase
import com.example.password.Model.Room.Repository.AccountRepository

class Appdata : Application() {

    lateinit var database : AccountDatabase
    val accountRepos by lazy {
        AccountRepository(database)
    }

    override fun onCreate() {
        super.onCreate()

        database = AccountDatabase.getDataBase(this)
    }
}