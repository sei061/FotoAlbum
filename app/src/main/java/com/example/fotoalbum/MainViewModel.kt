package com.example.fotoalbum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotoalbum.model.Users
import com.example.fotoalbum.repository.Repository
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos


class MainViewModel(private val repository: Repository): ViewModel() {


    val myUsersResponse: MutableLiveData<Users> = MutableLiveData()
    val myAlbumsResponse: MutableLiveData<Album> = MutableLiveData()
    val myPhotosResponse: MutableLiveData<Photos> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val response: Users = repository.getUsers()
            myUsersResponse.value = response
        }
    }
    fun getAlbums() {
        viewModelScope.launch {
            val response: Album = repository.getAlbums()
            myAlbumsResponse.value = response
        }
    }
    fun getPhotos() {
        viewModelScope.launch {
            val response: Photos = repository.getPhotos()
            myPhotosResponse.value = response
        }
    }


}