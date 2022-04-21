package com.watasolutions.week7_t6.screens.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.watasolutions.week7_t6.database.User
import com.watasolutions.week7_t6.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginViewModel
    lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserListAdapter()
        binding.rvUserData.layoutManager = LinearLayoutManager(context)
        binding.rvUserData.adapter = adapter

        registerSaveSuccess()

        binding.btnSave.setOnClickListener {
            val username = binding.tvUsername.editText?.text.toString().trim()
            val password = binding.tvPassword.editText?.text.toString().trim()

            val user = User(username, password)
            viewModel.addUser(user)

            Log.e("Button", "Save")
        }


        binding.btnLoad.setOnClickListener {
            adapter.setData(viewModel.loadUsersList())
            Log.e("Button", "Load")
        }

    }

    private fun registerSaveSuccess(){
        viewModel.saveEventSuccess.observe(viewLifecycleOwner){
            when(it) {true ->
                {
                    binding.tvUsername.editText?.setText("")
                    binding.tvPassword.editText?.setText("")
                }
            }
        }

    }


}