package com.example.fotoalbum.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class EntityUsers(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
)