package com.example.fotoalbum.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fotoalbum.API.MainViewModelFactory
import com.example.fotoalbum.Adapters.MyOnClickListener
import com.example.fotoalbum.Adapters.UserAdapter
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.databinding.FragmentUsersBinding
import com.example.fotoalbum.repository.Repository
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager


class UsersFragment : Fragment(), MyOnClickListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private val userAdapter by lazy {
        UserAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        setupRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getUser()
        viewModel.myUsersResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { userAdapter.setData(it) }
            } else {
                Log.d("Response", response.code().toString())
            }
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.usersList.adapter = userAdapter
        binding.usersList.layoutManager = LinearLayoutManager(context)
    }

    override fun onClick(position: Int) {
        val user = userAdapter.userList[position]
        val action = UsersFragmentDirections.actionUsersFragmentToAlbumsFragment(user)
        view?.findNavController()?.navigate(action)
    }
}