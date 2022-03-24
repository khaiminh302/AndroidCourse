package com.example.week3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val email: String, val password: String): Parcelable {

}