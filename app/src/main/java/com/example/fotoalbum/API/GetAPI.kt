package com.example.fotoalbum.API

import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos
import com.example.fotoalbum.model.Posts
import com.example.fotoalbum.model.Users
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetAPI {

    @GET("users")
    suspend fun getUsers(): Response<List<Users>>

    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<Photos>>

    @GET("photos")
    suspend fun getAllPhotos(): Response<List<Photos>>

    @GET("photos/{photoId}")
    suspend fun getPhotoById(
        @Path("photoId") photoId: Int
    ): Response<Photos>

    @GET("photos")
    suspend fun getPhotosByAlbumId(
        @Query("albumId") albumId: Int
    ): Response<List<Photos>>

    @GET("albums")
    suspend fun getAlbumByUserId(
        @Query("userId") userId: Int
    ): Response<List<Album>>

    @DELETE("posts/{postNumber}")
    suspend fun deletePost(
        @Path("postNumber") postId: Int
    ): Response<String>


}