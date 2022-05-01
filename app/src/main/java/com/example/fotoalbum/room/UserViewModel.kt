package com.example.fotoalbum.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel( application: Application): AndroidViewModel(application) {


    private val readAllData: LiveData<List<EntityUsers>>
    private val repository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).entityUsersDAO()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(entityUsers: EntityUsers){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(entityUsers)
        }
    }


}