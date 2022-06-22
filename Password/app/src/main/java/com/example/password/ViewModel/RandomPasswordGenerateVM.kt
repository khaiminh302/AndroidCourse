package com.example.password.ViewModel

import androidx.lifecycle.ViewModel
import com.example.password.Model.DataProcessor

class RandomPasswordGenerateVM: ViewModel() {

    fun generatePassword(passwordLengthInput: String, isNumberContain: Boolean, isCharContain: Boolean, isSpecialCharContain : Boolean) : String
    {
        var passwordLength = Integer.parseInt(passwordLengthInput)
        return DataProcessor.passwordGenerate(passwordLength, isNumberContain, isCharContain, isSpecialCharContain)
    }
}