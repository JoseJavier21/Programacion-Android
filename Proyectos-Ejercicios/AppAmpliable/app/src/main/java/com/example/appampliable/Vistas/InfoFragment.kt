package com.example.appampliable.Vistas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.databinding.FragmentInfoBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private var otorgar = PackageManager.PERMISSION_GRANTED
    private lateinit var mapa : GoogleMap
    private lateinit var seleccion : TablaCircuit
    private lateinit var coordendascero: LatLng
    private lateinit var cam: Uri
    private val ubicacionPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ){
        Permisos(mapa)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }



    private var llamadamapas = OnMapReadyCallback{
            googleMap -> mapa = googleMap
            googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID

            marcador(seleccion, googleMap)
            googleMap.setMinZoomPreference(0.40f)
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

    private fun marcador(tablaCircuit: TablaCircuit, map: GoogleMap){

        coordendascero = LatLng(tablaCircuit.latitud, tablaCircuit.longitud)

        val post = MarkerOptions().position(coordendascero)

        val precision = LatLngBounds.builder()
            .include(coordendascero)
            .build()

        val market = mapa.addMarker(post)
        mapa.animateCamera(CameraUpdateFactory.newLatLngBounds(precision, 5))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment?
        mapFragment?.getMapAsync(llamadamapas)

        val compro = arguments?.getInt("circuitos")
        val miapp = requireActivity().application as MyApp
//      val viem: ViewModel by activityViewModels {
//          ViewModel.MyViewModelFactory(myApp.repositorio)}

        binding.ciudad.text = seleccion.nombre
        binding.Pais.text = seleccion.pais
        binding.valo.text = seleccion.pregunta.toString()
//        binding.imagen.setImageURI(seleccion.imagen?).toUri())
    }
}