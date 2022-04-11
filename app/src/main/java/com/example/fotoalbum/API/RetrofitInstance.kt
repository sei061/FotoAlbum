package com.example.fotoalbum.API

import com.example.fotoalbum.Utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val api: GetAPI by lazy {
        retrofit.create(GetAPI::class.java)
    }
}