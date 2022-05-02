package com.example.fotoalbum.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.fotoalbum.R
import com.example.fotoalbum.mainactivity.MainActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        setHasOptionsMenu(true)
        (activity as MainActivity).supportActionBar?.title = "Preferences"






    }
}