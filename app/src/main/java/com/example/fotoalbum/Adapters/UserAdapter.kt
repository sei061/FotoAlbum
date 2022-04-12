package com.example.fotoalbum.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotoalbum.databinding.RowLayoutUserBinding
import com.example.fotoalbum.model.Users

class UserAdapter(val listener: MyOnClickListener): RecyclerView.Adapter<UserAdapter.UsersViewHolder>() {
    var userList = emptyList<Users>()

    inner class UsersViewHolder(var binding: RowLayoutUserBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = RowLayoutUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        with(holder) {
            binding.titleTxt.text = userList[position].name
        }
    }

    fun setData(newList: List<Users>) {
        userList = newList
        notifyDataSetChanged()
    }
}

interface MyOnClickListener {
    fun onClick(position: Int)
}

