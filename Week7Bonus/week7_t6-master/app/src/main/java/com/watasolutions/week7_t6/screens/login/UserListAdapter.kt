package com.watasolutions.week7_t6.screens.login

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.watasolutions.week7_t6.R
import com.watasolutions.week7_t6.database.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.findViewById<TextView>(R.id.tv_item_username).text = currentItem.username
        holder.itemView.findViewById<TextView>(R.id.tv_item_password).text = currentItem.password

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    // ====================================================================================================
    class UserListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        companion object {
            fun from(parent: ViewGroup): UserListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_user, parent, false)
                return UserListViewHolder(view)
            }
        }

//        fun bindData(user: User) {
//            val tvUser = itemView.findViewById<TextView>(R.id.tv_item_username);
//            val tvPassword = itemView.findViewById<TextView>(R.id.tv_item_password)
//            tvUser.text = user.username
//            tvPassword.text = user.password
//        }

    }

//    class UserDiffUtil : DiffUtil.ItemCallback<User>() {
//        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
//            return oldItem.username == newItem.username
//        }
//
//        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
//            return oldItem == newItem
//        }
//
//    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(user : List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}