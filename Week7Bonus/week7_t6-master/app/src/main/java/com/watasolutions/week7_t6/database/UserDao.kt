package com.watasolutions.week7_t6.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {

    @Query("SELECT * FROM users_data ORDER BY user_name ASC")
    suspend fun getAllUsers() : List<User>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)

}