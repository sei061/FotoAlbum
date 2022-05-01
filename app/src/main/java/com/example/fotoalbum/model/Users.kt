package com.example.fotoalbum.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users_table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
) : Parcelable






