package com.example.appampliable.Vistas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.example.appampliable.R
import com.example.appampliable.databinding.FragmentMapBinding
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding
    private lateinit var mapa : GoogleMap
    private var otorgar = PackageManager.PERMISSION_GRANTED
    private var localizacionpermiso = Manifest.permission.ACCESS_COARSE_LOCATION
    private lateinit var location: FusedLocationProviderClient
    private val ubicacionPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){

        Permisos(mapa)
    }

    private val callback = OnMapReadyCallback { googleMap ->

//        val rusia = LatLng(52.0, 213.0)
//        googleMap.addMarker(MarkerOptions().position(rusia).title("Marcador en Rusia"))
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(rusia))

        Permisosrevision(googleMap)
        mapa.mapType = GoogleMap.MAP_TYPE_HYBRID
        localizacion() // lo he puesto como una funcion por que si lo hacia directamente desde aqui no conseguia quitar los errores
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        val nav = findNavController()
        nav.navigate(R.id.listaFragment)
    }

    private fun localizacion(){
        if (context?.let { ActivityCompat.checkSelfPermission(it, localizacionpermiso) }
            != otorgar && context?.let { ActivityCompat.checkSelfPermission(it, localizacionpermiso)
            } != otorgar) {
            return
        }
        location.lastLocation.addOnSuccessListener { location ->
            val aqui = LatLng(location.latitude, location.longitude)
            val precision = LatLngBounds.builder()
                .include(aqui)
                .build()
            mapa.animateCamera(CameraUpdateFactory.newLatLngBounds(precision, 5))

        }
    }
    private fun Permisos(googleMap: GoogleMap): Boolean {
        if (context?.let { permiso(it, Manifest.permission.ACCESS_FINE_LOCATION) } == otorgar && context?.let { permiso(it, Manifest.permission.ACCESS_COARSE_LOCATION) } == otorgar)
        {
            if (context?.let {
                ActivityCompat.checkSelfPermission(it,Manifest.permission.ACCESS_FINE_LOCATION)
            }
            != PackageManager.PERMISSION_GRANTED && context?.let {
                ActivityCompat.checkSelfPermission(it,Manifest.permission.ACCESS_COARSE_LOCATION)
            }
                != PackageManager.PERMISSION_GRANTED)
            {return googleMap.isMyLocationEnabled}
            googleMap.isMyLocationEnabled = true
        }
        return googleMap.isMyLocationEnabled
    }

    private fun permiso(context: Context, permission: String): Int {
        return ActivityCompat.checkSelfPermission(context,permission)
    }

    private fun Permisosrevision(googleMap: GoogleMap){
        Permisos(googleMap)
        if (!Permisos(googleMap)){
            ubicacionPermissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION ))
        }
    }
}