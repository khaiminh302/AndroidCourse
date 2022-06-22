package com.example.password.View.Password

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.password.Model.DataProcessor
import com.example.password.Model.Room.AccountDefine
import com.example.password.R

class PasswordAdapter() : ListAdapter<AccountDefine, PasswordAdapter.PasswordViewHolder>(PasswordDiffUtil()) {

    class PasswordDiffUtil : DiffUtil.ItemCallback<AccountDefine>(){
        override fun areItemsTheSame(oldItem: AccountDefine, newItem: AccountDefine): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AccountDefine, newItem: AccountDefine): Boolean {
            return oldItem == newItem
        }
    }



    class PasswordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        companion object{
            fun from(parent: ViewGroup) : PasswordViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view =layoutInflater.inflate(R.layout.item_account_saved, parent, false)
                return  PasswordViewHolder(view)
            }
        }



        fun getData(account : AccountDefine){

            var noteOfAccount = itemView.findViewById<TextView>(R.id.display_note)
            var emailOfAccount = itemView.findViewById<TextView>(R.id.display_email)
            var passwordOfAccount = itemView.findViewById<TextView>(R.id.display_password)
            var logoOfAccount = itemView.findViewById<ImageView>(R.id.avatar)

            noteOfAccount.setText(account.note.toString().trim())
            emailOfAccount.setText(account.email.toString().trim())
            passwordOfAccount.setText(account.password.toString().trim())

            if(account.logo == null){
                logoOfAccount.setImageResource(R.drawable.browswer1)
            }else{
                logoOfAccount.setImageResource(account.logo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordViewHolder {
        return PasswordViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PasswordViewHolder, position: Int) {
        val info = getItem(position)

        val activity : AppCompatActivity  = holder.itemView.context as AppCompatActivity

        holder.itemView.setOnClickListener {
            DataProcessor.accountInfo = info
            activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, EditPassword()).addToBackStack(null).commit()
        }
        holder.getData(info)
    }
}