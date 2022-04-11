package com.example.fotoalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        viewModel.myUsersResponse.observe(this, Observer { response ->
            Log.d("Response", response.id.toString())
            Log.d("Response", response.name)
            Log.d("Response", response.username)
            Log.d("Response", response.email)
            Log.d("Response", response.address.toString())
            Log.d("Response", response.geo.toString())
            Log.d("Response", response.phone)
            Log.d("Response", response.website)
            Log.d("Response", response.company.toString())

        })


    }
}