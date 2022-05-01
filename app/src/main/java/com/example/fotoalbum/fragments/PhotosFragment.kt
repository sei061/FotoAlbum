package com.example.fotoalbum.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fotoalbum.viewmodelfactory.MainViewModelFactory
import com.example.fotoalbum.Adapters.MyOnClickListener
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.repository.Repository
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fotoalbum.Adapters.PhotosAdapter
import com.example.fotoalbum.databinding.FragmentPhotosBinding


class PhotosFragment : Fragment(), MyOnClickListener {

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private val photoAdapter by lazy {
        PhotosAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getPhotos()
        viewModel.myPhotosResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { photoAdapter.setData(it) }
            } else {
                Log.d("Response", response.code().toString())
            }
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.photosList.adapter = photoAdapter
        binding.photosList.layoutManager = LinearLayoutManager(context)
    }

    override fun onClick(position: Int) {
        val photo = photoAdapter.photosList[position]
        val action = PhotosFragmentDirections.actionPhotosFragmentToViewPhotosFragment(photo)
        view?.findNavController()?.navigate(action)
    }
}