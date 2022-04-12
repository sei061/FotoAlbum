package com.example.fotoalbum.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.fotoalbum.databinding.RowLayoutViewPhotosBinding

import com.example.fotoalbum.model.Photos

class ViewPhotosAdapter(val listener: MyOnClickListener): RecyclerView.Adapter<ViewPhotosAdapter.ViewPhotosViewHolder>() {
    var viewPhotosList = emptyList<Photos>()

    inner class ViewPhotosViewHolder(var binding: RowLayoutViewPhotosBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPhotosViewHolder {
        val binding = RowLayoutViewPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPhotosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return viewPhotosList.size

    }

    override fun onBindViewHolder(holder: ViewPhotosViewHolder, position: Int) {
        with(holder) {
            binding.editTextTitle.text = viewPhotosList[position].title
            val url = GlideUrl(viewPhotosList[position].url, LazyHeaders.Builder()
                .addHeader("User-Agent", "android")
                .build());
            Glide.with(holder.itemView.context)
                .load(url).override(150,150)
                .into(binding.imageView)

        }
    }

    fun setData(newList: List<Photos>) {
        viewPhotosList = newList
        notifyDataSetChanged()
    }
}