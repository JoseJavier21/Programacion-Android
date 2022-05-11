package com.example.aplicacionmapa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.aplicacionmapa.databinding.ActivityMainBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmet = supportFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment
        fragmet.getMapAsync(this)

//        val navController = findNavController(R.id.mapa)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onMapReady(mapa: GoogleMap) {
        mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID)
        mapa.isTrafficEnabled = true
        val uiSettings = mapa.getUiSettings()

        // Centrado de mapa
        val madrid = LatLng(40.47883646461693, -3.7692950517063832)
        val paris = LatLng(48.92116447022164, 2.4269937759977664)
        val portugal = LatLng( 38.7071, -9.13549)
        val region = LatLngBounds.Builder()
            .include(madrid)
            .include(paris)
            .include(portugal)
            .build()


        // Mientas carga el mapa
        mapa.setOnMapLoadedCallback {
            mapa.animateCamera(CameraUpdateFactory.newLatLngBounds(region, 10))
            Toast.makeText(this,"Cargando Mapa", Toast.LENGTH_SHORT).show()
        }

        CoroutineScope(Dispatchers.IO).launch {

        }


        // Para que se vean los botones de zoom
        uiSettings.isZoomControlsEnabled = false

        // Para que se vea la brujula
        uiSettings.isCompassEnabled = false

        // Gesto de zoom
        uiSettings.isZoomGesturesEnabled = true

        // Gesto de scroll
        uiSettings.isScrollGesturesEnabled = true

        // Gesto de angulo
        uiSettings.isTiltGesturesEnabled

        //Gesto de rotacion
        uiSettings.isRotateGesturesEnabled = true


        // Cuando se pulsa en la localizacion
        mapa.setOnMarkerClickListener { marker ->

             false
        }

        // Cuando se pulsa en el cartel de la localizacion
        mapa.setOnInfoWindowClickListener { marker ->
//            findNavController(R.id.mainActivity).navigate(R.id.infoSitios)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.mapa)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
