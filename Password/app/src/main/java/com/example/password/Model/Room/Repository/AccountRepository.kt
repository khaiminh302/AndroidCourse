package com.example.password.Model.Room.Repository

import com.example.password.Model.Room.AccountDatabase
import com.example.password.Model.Room.AccountDefine

class AccountRepository(val accountData : AccountDatabase) {

    suspend fun addNewAccount(
        note: String,
        email: String,
        password: String,
        logo: Int
    ){
        return accountData.Access().addNewAccount(
            AccountDefine(
                note = note,
                email = email,
                password = password,
                logo = logo
        )
        )
    }

    suspend fun deleteAll() {
        accountData.Access().deleteAll()
    }

    suspend fun deletaAccount( account : AccountDefine){
        accountData.Access().deleteAccount(account)
    }
    suspend fun updateAccount(note: String, password: String, email: String, uid: Int){
        accountData.Access().updateAccount(note, password, email, uid)
    }

    suspend fun getListAccount(): List<AccountDefine>{
        return accountData.Access().getListOfAccount()
    }
}