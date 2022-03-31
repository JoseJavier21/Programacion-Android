package com.example.proyectofinal

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectofinal.databinding.ContenedorBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.ui.AppBarConfiguration as AppBarConfiguration

class Contenedor: AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ContenedorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

//      VARIABLES    //

        val u = getIntent().extras

        val drawerLayout: DrawerLayout = binding.drawerlayout
        val navView: NavigationView = binding.navigationview
        val navController = findNavController(R.id.fragmentContainerView)

//      CODIGO      //

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_inicio,
                R.id.fragment_contacto,
                R.id.fragment_circuitos,
                R.id.fragment_pilotos
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

    override fun onBackPressed() {

        if(binding.drawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
}
