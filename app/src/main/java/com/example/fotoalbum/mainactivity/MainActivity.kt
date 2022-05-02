package com.example.fotoalbum.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fotoalbum.viewmodelfactory.MainViewModelFactory
import com.example.fotoalbum.MainViewModel
import com.example.fotoalbum.R
import com.example.fotoalbum.fragments.AboutFragment
import com.example.fotoalbum.fragments.SettingsFragment
import com.example.fotoalbum.repository.Repository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myToolbar: Toolbar = findViewById(R.id.myToolbar)
        myToolbar.title = "Users"
        setSupportActionBar(myToolbar)
        myToolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        //set onclick listener for back button
        myToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getUser()
        viewModel.myUsersResponse.observe(this) { response ->
            Log.d("Response", response.isSuccessful.toString())

        }

        val exitBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton5)

        exitBtn.setOnClickListener {
            this@MainActivity.finish()
            exitProcess(0)
        }

        val infoBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton4)

        infoBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,AboutFragment()).commit()
        }

        val settingsBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton3)

        settingsBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,
                SettingsFragment()
            ).commit()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()

    }
}