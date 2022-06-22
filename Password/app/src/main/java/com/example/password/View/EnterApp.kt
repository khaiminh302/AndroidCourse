package com.example.password.View

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.renderscript.ScriptGroup
import android.text.TextWatcher
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
import com.example.password.Model.DataProcessor
import com.example.password.Model.masterkeySharedStore
import com.example.password.R
import com.example.password.ViewModel.EnterAppViewModel
import com.example.password.databinding.FragmentEnterAppBinding
import com.google.android.material.internal.TextWatcherAdapter
import java.util.*

//NOTE : wrong masterkey, wait 3 minutes to continue
class EnterApp : Fragment() {

    private lateinit var enterBinding : FragmentEnterAppBinding
    private lateinit var enterVM : EnterAppViewModel

    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDownTimer: Long = 30000
    internal val countDownSecond : Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterVM = ViewModelProvider(this).get(EnterAppViewModel::class.java)
        enterBinding = FragmentEnterAppBinding.inflate(inflater,container,false)
        return enterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isMasterKeyCreated = enterVM.isMasterKeyExist(requireContext())

        if(isMasterKeyCreated)
        {
            enterBinding.tvCreateKey.setText("Enter Your Key")
        }

        var pinview : PinView  = enterBinding.masterkeyPinview
        pinview.requestFocus()
        setOnEnterTheKey(pinview)

        enterBinding.btnLogin.setOnClickListener{
            val masterkey = pinview.text.toString().trim()

            if(isMasterKeyCreated)
            {
                enterVM.checkLogin(masterkey,requireContext())
            }
            else
            {
                enterVM.createMasterKey(requireContext(),masterkey)
            }
        }
        loginSuccess()
        loginFail()
    }



    fun setOnEnterTheKey( pinview: PinView){

        val changeInput  = context?.getSystemService(Context.INPUT_METHOD_SERVICE)
        val inputmethod : InputMethodManager = changeInput as InputMethodManager
        inputmethod.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY)
        pinview.addTextChangedListener()
    }


    fun loginSuccess(){
        enterVM.successEvent.observe(viewLifecycleOwner){Success->
            if(Success){
                findNavController().navigate(R.id.action_enterApp_to_homeScreen)
            }
        }
    }

    fun loginFail(){
        enterVM.errorEvent.observe(viewLifecycleOwner){Error->
            Toast.makeText(context,Error,Toast.LENGTH_SHORT).show()
            lockLogin()
        }
    }

    fun lockLogin(){
        val initialTimer = initialCountDownTimer/1000
        val timeLeftDisplay = enterBinding.tvCountDownTimer
        timeLeftDisplay.setText(initialTimer.toString())

        countDownTimer = object : CountDownTimer(initialCountDownTimer,countDownSecond){
            override fun onTick(timerCount: Long) {
                val timeLeft = timerCount/1000
                preventLogin()
                timeLeftDisplay.setText(timeLeft.toString())
            }

            override fun onFinish() {
                countDownTimer.cancel()
                continueLogin()
            }
        }.start()
    }

    fun preventLogin(){
        enterBinding.btnLogin.setOnClickListener {
            enterBinding.masterkeyPinview.setText("")
        }
    }

    fun continueLogin()
    {
        var pinview : PinView  = enterBinding.masterkeyPinview
        enterBinding.btnLogin.setOnClickListener {
            val masterkey = pinview.text.toString().trim()
            var isMasterKeyCreated = enterVM.isMasterKeyExist(requireContext())

            if(isMasterKeyCreated)
            {
                enterVM.checkLogin(masterkey,requireContext())
            }
            else
            {
                enterVM.createMasterKey(requireContext(),masterkey)
            }
        }
    }


}