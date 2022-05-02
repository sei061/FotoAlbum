package com.example.fotoalbum.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fotoalbum.R
import com.example.fotoalbum.mainactivity.MainActivity

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as MainActivity).supportActionBar?.title = "About Us"
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        return view
    }


}