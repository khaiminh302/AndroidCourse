package com.watasolutions.week7_t6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_data")

data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_name") val username: String,
    @ColumnInfo (name = "user_password") val password: String
)