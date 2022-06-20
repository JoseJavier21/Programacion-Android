package com.example.weatherapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val mapa = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapa.getMapAsync(this)


        val navController = findNavController(R.id.FirstFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.addmark.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.addmark)
                .setAction("Action", null).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.tiempocasa -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }



    override fun onMapReady(p0: GoogleMap) {

        // Tipo de mapa usado
        p0.mapType = GoogleMap.MAP_TYPE_HYBRID
        p0.isTrafficEnabled = true

        val uiSettings = p0.uiSettings

        // Controles sobre el mapa
        uiSettings.isZoomControlsEnabled = true
        uiSettings.isZoomGesturesEnabled = true
        uiSettings.isScrollGesturesEnabled = true
        uiSettings.isRotateGesturesEnabled = true

        //Zoom maximo y minimo
        p0.setMinZoomPreference(6.0f)
        p0.setMaxZoomPreference(14.0f)

        //Centra el mapa en la ubicacion seleccionada


    }





}