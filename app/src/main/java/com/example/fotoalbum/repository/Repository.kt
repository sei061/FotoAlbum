package com.example.fotoalbum.repository

import com.example.fotoalbum.API.RetrofitInstance
import com.example.fotoalbum.model.Users

class Repository {

    suspend fun getPost(): Users{
        return RetrofitInstance.api.getUsers()
    }
}