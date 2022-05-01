package com.example.fotoalbum.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fotoalbum.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel( application: Application): AndroidViewModel(application) {


    private val readAllData: LiveData<List<Users>>
    private val repository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun getUser(Users: Users){
        viewModelScope.launch(Dispatchers.IO){
            repository.getUser(Users)
        }
    }


}