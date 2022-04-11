package com.example.fotoalbum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotoalbum.model.Users
import com.example.fotoalbum.repository.Repository
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository): ViewModel() {


    val myResponse: MuteableLiveData<Users> = MuteableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val
        }
    }
}