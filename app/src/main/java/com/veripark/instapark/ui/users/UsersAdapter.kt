package com.veripark.instapark.ui.users

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.veripark.instapark.R
import com.veripark.instapark.data.model.Users
import kotlinx.android.synthetic.main.item_users.view.*

class UsersAdapter (
    private val users: ArrayList<Users>
) : RecyclerView.Adapter<UsersAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(users: Users) {
            itemView.textViewUserName.text = users.name
            itemView.textViewUserEmail.text = users.email
            itemView.textViewUserCompany.text=users.company.name
Log.d("DataName",users.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder  =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_users, parent,
                false
            ))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersAdapter.DataViewHolder, position: Int)  =  holder.bind(users[position])

    fun addData(list: List<Users>) {
        users.addAll(list)
    }
}