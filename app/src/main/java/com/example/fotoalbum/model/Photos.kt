package com.example.fotoalbum.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photos(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Parcelable
