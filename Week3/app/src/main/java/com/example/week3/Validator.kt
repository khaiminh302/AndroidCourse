package com.example.week3

class Validator {
    companion object {
        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(password: String): Boolean {
            return password.length in 8..10
        }

        fun isNameValid(name: String): Boolean {
            return name.length > 0
        }
    }
}