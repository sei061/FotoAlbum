package com.example.fotoalbum.repository

import com.example.fotoalbum.API.RetrofitInstance
import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos
import com.example.fotoalbum.model.Users

class Repository {

    suspend fun getUsers(): Users{
        return RetrofitInstance.api.getUsers()
    }
    suspend fun getAlbums(): Album{
        return RetrofitInstance.api.getAlbums()
    }
    suspend fun getPhotos(): Photos{
        return RetrofitInstance.api.getPhotos()
    }
}