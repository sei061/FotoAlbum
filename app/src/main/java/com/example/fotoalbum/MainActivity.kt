package com.example.fotoalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fotoalbum.API.MainViewModelFactory
import com.example.fotoalbum.repository.Repository


class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getUser()
        viewModel.myUsersResponse.observe(this) { response ->
            Log.d("Response", response.isSuccessful.toString())

        }


    }
}