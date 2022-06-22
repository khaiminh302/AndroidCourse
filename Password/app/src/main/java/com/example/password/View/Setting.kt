package com.example.password.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.password.Model.DataProcessor
import com.example.password.R
import com.example.password.ViewModel.SettingVM
import com.example.password.ViewModel.ViewModelFactory.PasswordFactory.Appdata
import com.example.password.ViewModel.ViewModelFactory.SettingVMFactory
import com.example.password.databinding.FragmentSettingBinding


class Setting : Fragment() {

    private lateinit var settingBind : FragmentSettingBinding
    private lateinit var setVM : SettingVM




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingBind = FragmentSettingBinding.inflate(inflater,container,false)
        setVM = ViewModelProvider(this, SettingVMFactory(context?.applicationContext as Appdata))[SettingVM::class.java]
        return settingBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var switchSecurityMode = settingBind.switchSecurityMode

        initSwitch(switchSecurityMode)

        setVM.switchInitial()

        settingBind.tvChangeMasterKey.setOnClickListener{
            findNavController().navigate(R.id.action_setting_to_changeMasterKey)
        }

        switchSecurityMode.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isSecurityModeOn ->
            setVM.setTheSecurityMode(isSecurityModeOn)
        })

        settingBind.btnDeleteList.setOnClickListener {
            setVM.deleteAll()
        }
    }

    fun initSwitch(switch: Switch){
        setVM.setEvent.observe(viewLifecycleOwner){checked->
            if(checked){
                switch.isChecked = checked
            }
        }
    }
}