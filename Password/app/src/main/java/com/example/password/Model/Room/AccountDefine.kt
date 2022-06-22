package com.example.password.Model.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class AccountDefine(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,

    @ColumnInfo(name = "Note")
    val note : String?,

    @ColumnInfo(name = "Email")
    val email: String?,

    @ColumnInfo(name = "Password")
    val password : String?,

    @ColumnInfo(name = "Logo")
    val logo : Int?
)
