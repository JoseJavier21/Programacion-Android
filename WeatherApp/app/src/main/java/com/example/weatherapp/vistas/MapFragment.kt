package com.example.weatherapp.vistas

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import java.util.jar.Manifest

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private lateinit var mapa : GoogleMap
    private lateinit var locationClient: FusedLocationProviderClient
    private val permisouno = PackageManager.PERMISSION_GRANTED
    private val permisodos = android.Manifest.permission.ACCESS_COARSE_LOCATION
    private val ubicacionPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){

        ifPermiso(mapa)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
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

        localizacion()
    }




    //Localizacion

    private fun localizacion(){
        if (context?.let { ActivityCompat.checkSelfPermission(it, permisodos) }
            != permisouno && context?.let { ActivityCompat.checkSelfPermission(it, permisodos)
            } != permisouno) {
            return
        }
        locationClient.lastLocation.addOnSuccessListener { location ->
            val aqui = LatLng(location.latitude, location.longitude)
            val precision = LatLngBounds.builder()
                .include(aqui)
                .build()
            mapa.animateCamera(CameraUpdateFactory.newLatLngBounds(precision, 10))

        }
    }


    //Permisos y chequeo de estos

    private fun ifPermiso(googleMap: GoogleMap): Boolean {
        if (context?.let { permiso(it, android.Manifest.permission.ACCESS_FINE_LOCATION) } == permisouno
            && context?.let { permiso(it, android.Manifest.permission.ACCESS_COARSE_LOCATION) } == permisouno
        ) {
            if (context?.let {
                    ActivityCompat.checkSelfPermission(
                        it,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    )
                } != PackageManager.PERMISSION_GRANTED && context?.let {
                    ActivityCompat.checkSelfPermission(
                        it,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                } != PackageManager.PERMISSION_GRANTED
            ) {
                return googleMap.isMyLocationEnabled
            }
            googleMap.isMyLocationEnabled = true


        }
        return googleMap.isMyLocationEnabled
    }

    private fun permiso(context: Context, permission: String): Int {
        return ActivityCompat.checkSelfPermission(context,permission)
    }

    private fun checkPermiso(googleMap: GoogleMap){
        ifPermiso(googleMap)
        if (!ifPermiso(googleMap)){
            ubicacionPermissionLauncher.launch(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION ))
        }
    }


}