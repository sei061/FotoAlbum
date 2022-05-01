package com.example.fotoalbum.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fotoalbum.viewmodelfactory.MainViewModelFactory
import com.example.fotoalbum.Adapters.MyOnClickListener
import com.example.fotoalbum.Adapters.UserAdapter
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.databinding.FragmentUsersBinding
import com.example.fotoalbum.repository.Repository
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fotoalbum.model.Users
import com.example.fotoalbum.room.EntityUsers
import com.example.fotoalbum.room.UserViewModel


class UsersFragment : Fragment(), MyOnClickListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var dUserViewModel: UserViewModel
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
        dUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUser()
        viewModel.myUsersResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let { userAdapter.setData(it) }
            } else {
                Log.d("Response", response.code().toString())
            }

        }
        binding.floatingActionButton.setOnClickListener {
        insertDataToDatabase()
        }
        return binding.root

    }

    private fun setupRecyclerView() {
        binding.usersList.adapter = userAdapter
        binding.usersList.layoutManager = LinearLayoutManager(context)
    }
    private fun insertDataToDatabase() {
        for (i in 0 until userAdapter.userList.size) {
            var id = userAdapter.userList[i].id
            var name = userAdapter.userList[i].name
            var email = userAdapter.userList[i].email

            var user = Users(id, name, email)

            dUserViewModel.getUser(user)
            Toast.makeText(requireContext(), "Successfully reloaded!", Toast.LENGTH_LONG).show()


        }
    }

    override fun onClick(position: Int) {
        val user = userAdapter.userList[position]
        val action = UsersFragmentDirections.actionUsersFragmentToAlbumsFragment(user)
        view?.findNavController()?.navigate(action)
    }

}