package com.example.fotoalbum.API

import com.example.fotoalbum.model.Users
import retrofit2.http.GET

interface GetAPI {

    @GET("/users")
    suspend fun getUsers(): Users

}