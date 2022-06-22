package com.example.password.Model

import java.util.regex.Matcher
import java.util.regex.Pattern

class Validator {

    //val PASSWORD_PATTERN : Pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W)(?=.*\\S+$).{8,}$")
    val EMAIL_PATTERN : Pattern = Pattern.compile("[\\w\\W]+[@][\\w\\W]+[.][\\w\\W]{3}")



    /*fun isPasswordValid(password: String) : Boolean{
        val checkPassword : Matcher = PASSWORD_PATTERN.matcher(password)
        return checkPassword.matches()
    }*/

    fun isEmailValid(email: String): Boolean{
        val checkEmail : Matcher = EMAIL_PATTERN.matcher(email)
        return  checkEmail.matches()
    }

}