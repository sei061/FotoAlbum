package com.example.fotoalbum.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val userid: Int,
    val id: Int,
    val title: String,
) : Parcelable
