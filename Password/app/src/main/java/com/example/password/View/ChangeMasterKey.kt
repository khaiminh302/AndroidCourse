package com.example.password.View

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.chaos.view.PinView
import com.example.password.Model.masterkeySharedStore
import com.example.password.R
import com.example.password.ViewModel.ChangeMasterKeyVM
import com.example.password.ViewModel.EnterAppViewModel
import com.example.password.databinding.FragmentChangeMasterKeyBinding
import java.lang.IllegalArgumentException

class ChangeMasterKey : Fragment() {


    private lateinit var changeBind : FragmentChangeMasterKeyBinding
    private lateinit var changeVM : ChangeMasterKeyVM

    var isEnterSuccess = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeBind = FragmentChangeMasterKeyBinding.inflate(inflater,container,false)
        changeVM = ViewModelProvider(this).get(ChangeMasterKeyVM::class.java)
        return changeBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var pinView : PinView = changeBind.changeMasterkeyPinview
        pinView.requestFocus()
        val changeInput = context?.getSystemService(Context.INPUT_METHOD_SERVICE)
        val inputMethod : InputMethodManager = changeInput as InputMethodManager
        inputMethod.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        pinView.addTextChangedListener()

        changeBind.btnChange.setOnClickListener {
            val masterKey = pinView.text.toString().trim()
            changeVM.checkMasterKey(requireContext(),masterKey)
            enterMasterKeySuccess()
            Log.e("Enter", true.toString())
            if(isEnterSuccess)
            {
                Log.e("Enter Success", true.toString())
                changeBind.btnChange.setOnClickListener {
                    val newMasterKey = changeBind.changeMasterkeyPinview.text.toString().trim()
                    changeVM.registerNewMasterKey(requireContext(), newMasterKey)
                }
            }
        }
        changeMasterKeySuccess()
        changeMasterKeyFail()
    }


    fun changeMasterKeySuccess()
    {
        changeVM.successChange.observe(viewLifecycleOwner)
        {successChange->
            if(successChange)
            {
                findNavController().navigate(R.id.action_changeMasterKey_to_setting)
            }
        }
    }

    fun changeMasterKeyFail()
    {
        changeVM.errorChange.observe(viewLifecycleOwner)
        {errorChange->
            Toast.makeText(context,errorChange,Toast.LENGTH_SHORT).show()
            changeBind.changeMasterkeyPinview.setText("")
        }
    }

    fun enterMasterKeySuccess()
    {
        changeVM.successEvent.observe(viewLifecycleOwner)
        {success->
            if(success)
            {
                changeBind.changeMasterkeyPinview.setText("")
                changeBind.tvInstructionChange.setText("Enter New Master Key")
                isEnterSuccess = true
            }
        }
    }

    fun enterMasterKeyFail()
    {

    }
}