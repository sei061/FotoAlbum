package com.example.fotoalbum.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fotoalbum.API.MainViewModelFactory
import com.example.fotoalbum.Adapters.MyOnClickListener
import com.example.fotoalbum.Adapters.ViewPhotosAdapter
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.databinding.FragmentViewPhotosBinding
import com.example.fotoalbum.repository.Repository


class ViewPhotosFragment : Fragment(), MyOnClickListener {

    private var _binding: FragmentViewPhotosBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private val viewPhotosAdapter by lazy {
        ViewPhotosAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewPhotosBinding.inflate(inflater, container, false)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPhotosByUserId(id)
        viewModel.myPhotosByUserId.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { viewPhotosAdapter.setData(it) }
            } else {
                Log.d("Response", response.code().toString())
            }
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.photosList.adapter= viewPhotosAdapter
        binding.photosList.layoutManager = LinearLayoutManager(context)
    }
    override fun onClick(position: Int) {
        TODO("Not yet implemented")
    }
}