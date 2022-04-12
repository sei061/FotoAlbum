package com.example.fotoalbum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotoalbum.model.Users
import com.example.fotoalbum.repository.Repository
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import com.example.fotoalbum.model.Album
import com.example.fotoalbum.model.Photos
import com.example.fotoalbum.model.Posts
import retrofit2.Response


class MainViewModel(private val repository: Repository): ViewModel() {


    val myUsersResponse: MutableLiveData<Response<List<Users>>> = MutableLiveData()
    val myAlbumsResponse: MutableLiveData<Response<List<Album>>> = MutableLiveData()
    val myPhotosResponse: MutableLiveData<Response<List<Photos>>> = MutableLiveData()
    val myPostsResponse: MutableLiveData<Response<List<Posts>>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val response: Response<List<Users>> = repository.getUsers()
            myUsersResponse.value = response
        }
    }
    fun getAlbums() {
        viewModelScope.launch {
            val response: Response<List<Album>> = repository.getAlbums()
            myAlbumsResponse.value = response
        }
    }
    fun getPhotos() {
        viewModelScope.launch {
            val response: Response<List<Photos>> = repository.getPhotos()
            myPhotosResponse.value = response
        }
    }
    fun getPostsByUserId(userId: Int) {
        viewModelScope.launch {
            val response: Response<List<Posts>> = repository.getPostsByUserId(userId)
            myPostsResponse.value = response
        }
    }


}