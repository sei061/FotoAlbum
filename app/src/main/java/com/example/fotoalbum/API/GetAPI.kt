package com.example.fotoalbum.API

import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos
import com.example.fotoalbum.model.Posts
import com.example.fotoalbum.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAPI {

    @GET("users")
    suspend fun getUsers(): Response<List<Users>>

    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<Photos>>

    @GET("posts")
    suspend fun getPhotosByUserId(
        @Query("userId") userId: Int
    ): Response<List<Posts>>


}