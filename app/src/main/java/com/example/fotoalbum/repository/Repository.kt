package com.example.fotoalbum.repository

import com.example.fotoalbum.API.RetrofitInstance
import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos
import com.example.fotoalbum.model.Posts
import com.example.fotoalbum.model.Users
import retrofit2.Response

class Repository {

    suspend fun getUsers(): Response<List<Users>> {
        return RetrofitInstance.api.getUsers()
    }
    suspend fun getAlbums(): Response<List<Album>> {
        return RetrofitInstance.api.getAlbums()
    }
    suspend fun getPhotos(): Response<List<Photos>> {
        return RetrofitInstance.api.getPhotos()
    }
    suspend fun getPostsByUserId(userId: Int): Response<List<Posts>> {
        return RetrofitInstance.api.getPostsByUserId(userId)
    }
}