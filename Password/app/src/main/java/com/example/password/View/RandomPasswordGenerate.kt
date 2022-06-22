package com.example.password.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.lifecycle.ViewModelProvider
import com.example.password.Model.DataProcessor
import com.example.password.R
import com.example.password.ViewModel.RandomPasswordGenerateVM
import com.example.password.databinding.FragmentRandomPasswordGenerateBinding
import java.lang.IllegalArgumentException


class RandomPasswordGenerate : Fragment() {

    private lateinit var randomBind : FragmentRandomPasswordGenerateBinding
    private lateinit var randomVM  : RandomPasswordGenerateVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        randomBind = FragmentRandomPasswordGenerateBinding.inflate(inflater,container,false)
        randomVM = ViewModelProvider(this).get(RandomPasswordGenerateVM::class.java)
        return randomBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val passwordLengthInput = randomBind.edtPasswordLengthInput

        val switchNumber: Switch    = randomBind.switchNumber
        val switchChar              = randomBind.switchCharacter
        val switchSpecialChar       = randomBind.switchSpecialCharacter

        val generatePassword = randomBind.tvPasswordGenerator

        val generateBtn = randomBind.btnGenerate

        generateBtn.setOnClickListener {

            try{
                val isNumberContain = switchNumber.isChecked
                val isCharContain = switchChar.isChecked
                val isSpecialCharContain = switchSpecialChar.isChecked
                val passwordLength = passwordLengthInput.text.toString()
                generatePassword.text = randomVM.generatePassword(passwordLength,isNumberContain,isCharContain,isSpecialCharContain)
            }
            catch (inputNotFound : NumberFormatException)
            {
                generatePassword.text = "Please enter the length of password you want"
                generatePassword.setTextColor(resources.getColor(R.color.warning))
                generatePassword.setBackgroundResource(R.drawable.warning_generate)
            }
            catch ( cannotFindMode : IllegalArgumentException)
            {
                generatePassword.text = "Please choose a mode"
                generatePassword.setTextColor(resources.getColor(R.color.warning))
                generatePassword.setBackgroundResource(R.drawable.warning_generate)
            }
        }
    }
}