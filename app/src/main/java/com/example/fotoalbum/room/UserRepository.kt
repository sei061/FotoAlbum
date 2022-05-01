package com.example.fotoalbum.room
import androidx.lifecycle.LiveData

class UserRepository( private val userDao: EntityUsersDAO) {

    val readAllData: LiveData<List<EntityUsers>> = userDao.readAllData()

    suspend fun addUser(entityUsers: EntityUsers) {
        userDao.addUser(entityUsers)
    }


    }