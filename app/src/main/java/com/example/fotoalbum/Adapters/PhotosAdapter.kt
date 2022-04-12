package com.example.fotoalbum.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.fotoalbum.R
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
            val url = GlideUrl(photosList[position].thumbnailUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", "android")
                .build());
            Glide.with(holder.itemView.context)
                .load(url).override(150,150)
                .into(binding.photosImage)
        }
    }

    fun setData(newList: List<Photos>) {
        photosList = newList
        notifyDataSetChanged()
    }
}


