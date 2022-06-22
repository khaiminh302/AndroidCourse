package com.example.password.Model

import android.content.Context
import android.content.SharedPreferences
import android.widget.ImageView
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.password.Model.Room.AccountDefine
import java.lang.StringBuilder
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.random.Random

object DataProcessor {

     var accountInfo : AccountDefine? = null

    var isSecurityModeOn : Boolean = false


    fun isEmailValid(email: String) : Boolean{
        val emailChecking = Validator()
        return  true //emailChecking.isEmailValid(email)
    }


    fun isPasswordAppearManyTime(password: String, listOfAccount : List<AccountDefine>): Boolean{
        for(i in 0..listOfAccount.size-1){
            if( password == listOfAccount.elementAt(i).password){
                return true
            }
        }
        return false
    }

    fun passwordGenerate(passwordLength : Int, isContainNumber : Boolean, isContainChar : Boolean, isContainSpecialChar : Boolean) : String{

        val random  = Random
        val NUMBER_SEQUENCE = "0123456789"
        val CHARACTER_SEQUENCE = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"
        val SPECIAL_CHARACTER_SEQUENCE = "!@#$%^&*()-=_+~`':;}]{[|?//>.<,'"

        var RANDOM_CHAR_SEQUENCE = ""

        var randomPass  = StringBuilder(passwordLength)

        if(isContainChar){
            RANDOM_CHAR_SEQUENCE += CHARACTER_SEQUENCE
        }

        if(isContainNumber){
            RANDOM_CHAR_SEQUENCE += NUMBER_SEQUENCE
        }

        if(isContainSpecialChar){
            RANDOM_CHAR_SEQUENCE += SPECIAL_CHARACTER_SEQUENCE
        }

        for( i in 0..passwordLength-1){
            randomPass.append(RANDOM_CHAR_SEQUENCE[random.nextInt(RANDOM_CHAR_SEQUENCE.length-1)])
        }

        return randomPass.toString().trim()

    }
}