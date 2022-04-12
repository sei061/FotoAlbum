package com.example.fotoalbum.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fotoalbum.viewmodelfactory.MainViewModelFactory
import com.example.fotoalbum.Adapters.AlbumsAdapter
import com.example.fotoalbum.Adapters.MyOnClickListener
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.databinding.FragmentAlbumsBinding
import com.example.fotoalbum.repository.Repository

class AlbumsFragment : Fragment(), MyOnClickListener {

    private var _binding: FragmentAlbumsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private val albumsAdapter by lazy {
        AlbumsAdapter(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAlbums()
        viewModel.myAlbumsResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { albumsAdapter.setData(it) }
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.albumsList.adapter = albumsAdapter
        binding.albumsList.layoutManager = LinearLayoutManager(context)

    }

    override fun onClick(position: Int) {
        val albums = albumsAdapter.albumsList[position]
        val action = AlbumsFragmentDirections.actionAlbumsFragmentToPhotosFragment(albums)
        view?.findNavController()?.navigate(action)

    }

}