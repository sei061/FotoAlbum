package com.example.fotoalbum.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotoalbum.databinding.RowLayoutPhotosBinding
import com.example.fotoalbum.model.Photos

class PhotosAdapter(val listener: MyOnClickListener): RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    var photosList = emptyList<Photos>()

    inner class PhotosViewHolder(var binding: RowLayoutPhotosBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = RowLayoutPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        with(holder) {
            binding.photosTxt.text = photosList[position].title
            //binding.titleTxt.text = userList[position].name

        }
    }

    fun setData(newList: List<Photos>) {
        photosList = newList
        notifyDataSetChanged()
    }
}


