package com.example.password.Model

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import java.util.*

object masterkeySharedStore  {

    private val MASTERKEY_KEYWORD = "MASTERKEY"
    private val MASTERKEY_STATE_KEYWORD = "MASTERKEY_STATE"


    fun createSecurityDataBase(context: Context) : SharedPreferences {

        val masterKeyAlias : String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            "secret_database",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        return sharedPreferences
    }

    fun isMasterKeyCreated(context: Context): Boolean {
        var isMasterKeyExist = createSecurityDataBase(context).getBoolean(MASTERKEY_STATE_KEYWORD, false)
        return isMasterKeyExist
    }


     fun isMasterKeyValid(masterkey: String): Boolean {
         return masterkey.length == 4
     }


    fun isMasterKeyCorrect(context: Context, masterKey: String) : Boolean {
        val editor : SharedPreferences.Editor = createSecurityDataBase(context).edit()
        var masterkey = createSecurityDataBase(context).getString(MASTERKEY_KEYWORD, "")
        return masterKey == masterkey
    }


    fun saveMasterKey(context: Context, MasterKey: String) {
        val editor : SharedPreferences.Editor = createSecurityDataBase(context).edit()
        editor.putString(MASTERKEY_KEYWORD, MasterKey).apply()
        editor.putBoolean(MASTERKEY_STATE_KEYWORD, true).apply()
    }
}