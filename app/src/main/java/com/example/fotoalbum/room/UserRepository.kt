package com.example.fotoalbum.room
import androidx.lifecycle.LiveData
import com.example.fotoalbum.API.RetrofitInstance
import com.example.fotoalbum.model.Users
import retrofit2.Response

class UserRepository( private val userDao: UsersDAO) {

    val readAllData: LiveData<List<Users>> = userDao.readAllData()

    suspend fun getUser(user: Users) {
        userDao.getUser(user)

    }


    }