package com.example.aplicacionmapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacionmapa.databinding.ActivityMainBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmet = supportFragmentManager.findFragmentById(R.id.FragmentMaps) as SupportMapFragment
        fragmet.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        p0.setMapType(GoogleMap.MAP_TYPE_HYBRID)
        p0.isTrafficEnabled = true
        val uiSettings = p0.getUiSettings()

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


        // Para cambiar la posicion y zomm de la camara
         val latLng = LatLng(32.00, 323.00) // cambias numeros
            CameraUpdateFactory.newLatLngZoom(latLng, 8f)




    }
}
