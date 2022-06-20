package com.example.weatherapp.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.retrofit.Repositorio
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navController = findNavController(R.id.fragmentContainerView2)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstFragment,
                R.id.secondFragment,
            )
        )

        val fragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        fragment.getMapAsync(this)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.downmenu.setupWithNavController(navController)

    }

    override fun onMapReady(map: GoogleMap) {

        //Tipo de mapa usado
        map.mapType = GoogleMap.MAP_TYPE_HYBRID

        //Permite ver la densidad de trafico
        map.isTrafficEnabled = true

        //Controles sobre el mapa
         val uiSetting = map.uiSettings

        //Muestra los controles de zoom
        uiSetting.isZoomControlsEnabled = false

        //Permite hacer zoom
        uiSetting.isZoomGesturesEnabled = true

        //Permite hacer scroll
        uiSetting.isScrollGesturesEnabled = true

        //Permite hacer rotacion
        uiSetting.isRotateGesturesEnabled = true

        //Zoom max y min
        map.setMaxZoomPreference(6.0f)
        map.setMinZoomPreference(14.0f)

//      map.moveCamera(CameraUpdateFactory.newLatLngZoom("nombre de la variable para situar el mapa en la ubicacion de cada uno"))

//        map.setOnMapClickListener {
//
//        }

    }


}