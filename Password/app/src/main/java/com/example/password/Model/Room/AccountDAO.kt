package com.example.password.Model.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface AccountDAO {

    @Query("SELECT*FROM Account")
    suspend fun getListOfAccount(): List<AccountDefine>

    @Insert
    suspend fun addNewAccount(vararg account : AccountDefine)

    @Delete
    suspend fun deleteAccount(accout : AccountDefine)

    @Query("DELETE FROM Account")
    suspend fun deleteAll()

    @Query("UPDATE Account SET Note = :note, Email = :email, Password = :password WHERE uid = :uid")
    suspend fun updateAccount(note: String, password: String, email: String, uid: Int)

}