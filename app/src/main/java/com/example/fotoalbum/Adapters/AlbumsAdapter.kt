package com.example.fotoalbum.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotoalbum.databinding.RowLayoutAlbumsBinding

import com.example.fotoalbum.model.Album

class AlbumsAdapter(val listener: MyOnClickListener): RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    var albumsList = emptyList<Album>()

    inner class AlbumsViewHolder(var binding: RowLayoutAlbumsBinding): RecyclerView.ViewHolder(binding.root) {
        init{
            itemView.setOnClickListener{
                val position = adapterPosition
                    listener.onClick(position)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsAdapter.AlbumsViewHolder {
        val binding = RowLayoutAlbumsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return albumsList.size
    }

    override fun onBindViewHolder(holder: AlbumsAdapter.AlbumsViewHolder, position: Int) {
        with(holder){
            binding.titleTxtAlbum.text = albumsList[position].title
        }
    }

    fun setData(newList: List<Album>){
        albumsList = newList
        notifyDataSetChanged()
    }
}