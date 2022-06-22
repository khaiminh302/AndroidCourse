package com.example.password.Model.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AccountDefine::class], version = 1, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {

    abstract fun Access() : AccountDAO

    companion object{

        @Volatile
        private var INSTANCE: AccountDatabase? = null

        fun getDataBase(context: Context) : AccountDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountDatabase::class.java, "account_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }



    }



}