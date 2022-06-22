package com.example.password.View.Password

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.password.Model.DataProcessor
import com.example.password.R
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import com.example.password.ViewModel.PasswordVM
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.PasswordVMFactory
import com.example.password.databinding.FragmentPasswordBinding


class Password : Fragment() {

    private lateinit var passBind : FragmentPasswordBinding
    private lateinit var passwordAdapter : PasswordAdapter
    private lateinit var passVM : PasswordVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        passBind = FragmentPasswordBinding.inflate(inflater, container, false)


        passVM = ViewModelProvider(
            this,
            PasswordVMFactory(context?.applicationContext as Appdata)
        )[PasswordVM::class.java]

        return passBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        passwordAdapter = PasswordAdapter()
        passVM.getListOfAccountFromDataBase()
        registerData()
        passBind.displayAccountList.layoutManager = LinearLayoutManager(requireContext())
        passBind.displayAccountList.adapter = passwordAdapter


        passBind.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_password_to_enterAccount)
        }


    }

    fun registerData(){
        passVM.loadData.observe(viewLifecycleOwner){data->
            passwordAdapter.submitList(data)
        }
    }

    override fun onStart() {
        super.onStart()
        passVM.getListOfAccountFromDataBase()
    }




}