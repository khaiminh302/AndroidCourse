package com.example.password.View.EnterAccount

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.password.R
import com.example.password.ViewModel.EnterAccountVM
import com.example.password.ViewModel.ViewModelFactory.EnterAccount.EnterAccountVMFactory
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import com.example.password.databinding.FragmentEnterAccountBinding


class EnterAccount : Fragment() {

    private lateinit var enterBinding : FragmentEnterAccountBinding
    private lateinit var enterVM : EnterAccountVM
    private var logoToSave = R.drawable.browswer1
    var dialog  : AlertDialog? = null

    val accountType  = listOf(
        "Google",
        "Facebook",
        "Github",
        "Other Account"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        enterBinding = FragmentEnterAccountBinding.inflate(inflater,container,false)
        enterVM = ViewModelProvider(this,EnterAccountVMFactory(context?.applicationContext as Appdata))[EnterAccountVM::class.java]

        return enterBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val type_selector : AutoCompleteTextView = enterBinding.accountSelector
        val adapaterItem  = ArrayAdapter(requireContext(),R.layout.drop_down_item, accountType)
        type_selector.setAdapter(adapaterItem)

        type_selector.setOnItemClickListener { adapterView, view, position, l ->
            val typeAccount : String = adapterView.getItemAtPosition(position).toString()
            changeLogoFollowTypeAccount(typeAccount)
            Toast.makeText(context,typeAccount,Toast.LENGTH_SHORT).show()
        }

        enterBinding.btnSave.setOnClickListener {
            var email       = enterBinding.edtEnterEmail.text.toString().trim()
            var password    = enterBinding.edtEnterPassword.text.toString().trim()
            var note        = enterBinding.edtEnterNote.text.toString().trim()
            enterVM.isSecurityPasswordModeOn()
            passwordSecurityMode(email,password,note,logoToSave)
        }
        addSuccess()
        addFail()
    }

    fun passwordSecurityMode(email: String,password: String,note: String,logoToSave: Int){
        enterVM.modeOnEvent.observe(viewLifecycleOwner){modeOn->
            if(modeOn){
                warningPassword(email,password,note,logoToSave)
            }else{
                registerAccount(email,password,note,logoToSave)
                Log.e("Call register",true.toString())
            }
        }
    }

    fun warningPassword(email: String, password: String, note: String, logo: Int){
        Log.e("Call warning passwordfunction", true.toString())
        enterVM.isPasswordAppearFreq(password)
        enterVM.notDetectEvent.observe(viewLifecycleOwner){notDetect->
            if(notDetect){
                registerAccount(email, password, note, logo)
            }else{
                enterVM.detectEvent.observe(viewLifecycleOwner){detect->
                        val builder = AlertDialog.Builder(context)
                        builder.setTitle("Warning!!!")
                        builder.apply {
                            setMessage(detect)
                            Log.e("Call dialog", true.toString())
                            setPositiveButton("Ok, I got it") { dialog, _ ->
                                registerAccount(email, password, note, logo)
                            }
                        }
                    if(dialog != null) {
                        dialog!!.dismiss()
                    }
                    dialog = builder.show()
                    }
                }
            }
        }

    fun registerAccount(email: String, password: String, note: String, logo: Int){
        Log.e("Register Account", true.toString())
        enterVM.registerNewAccount(email,password,note,logo)
    }

    fun addSuccess(){
        enterVM.successEvenet.observe(viewLifecycleOwner){ success->
            if(success){
                findNavController().navigate(R.id.action_enterAccount_to_password)
            }

        }
    }

    fun addFail(){
        enterVM.errorEvent.observe(requireParentFragment().viewLifecycleOwner){fail->
            Toast.makeText(context,fail,Toast.LENGTH_SHORT).show()
        }
    }

    fun changeLogoFollowTypeAccount(typeAccount: String){
        when(typeAccount){
            "Google" ->  {enterBinding.sivIcon.setImageResource(R.drawable.google)
                          logoToSave = R.drawable.google}
            "Facebook" -> {enterBinding.sivIcon.setImageResource(R.drawable.facebook)
                          logoToSave = R.drawable.facebook}
            "Github" -> {enterBinding.sivIcon.setImageResource(R.drawable.github)
                        logoToSave = R.drawable.github}
            "Other Account" -> {enterBinding.sivIcon.setImageResource(R.drawable.browswer1)
                        logoToSave = R.drawable.browswer1}
        }
    }



}