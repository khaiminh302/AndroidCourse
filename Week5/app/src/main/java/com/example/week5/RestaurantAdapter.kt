package com.example.week5



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.model.Restaurant

class RestaurantAdapter: ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = getItem(position)
        holder.bindData(restaurant)
    }

    class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }

    }


    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup): RestaurantViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_restaurant, parent, false)
                return RestaurantViewHolder(view)
            }
        }

        fun bindData(restaurant: Restaurant) {
            val tvName = itemView.findViewById<TextView>(R.id.tv_name);
            val tvAddress = itemView.findViewById<TextView>(R.id.tv_address)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.imageAvatar)
            tvName.text = restaurant.name
            tvAddress.text = restaurant.address
            ivAvatar.setImageResource(restaurant.avatar)
        }
    }

 /*   class RestaurantViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView){
        companion object {
            fun from(parent: ViewGroup): RestaurantViewHolder2 {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_restaurant2, parent, false)
                return RestaurantViewHolder2(view)
            }
        }

        fun bindData2(restaurant: Restaurant) {
            val tvName = itemView.findViewById<TextView>(R.id.tv_name2);
            val tvAddress = itemView.findViewById<TextView>(R.id.tv_address2)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.imageAvatar2)
            tvName.text = restaurant.name
            tvAddress.text = restaurant.address
            ivAvatar.setImageResource(restaurant.avatar)
        }

    }*/

}



