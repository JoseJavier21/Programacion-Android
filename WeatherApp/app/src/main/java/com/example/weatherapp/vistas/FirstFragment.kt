package com.example.weatherapp.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentFirstBinding
import com.example.weatherapp.retrofit.Repositorio
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var map: GoogleMap
    private lateinit var localitation: LatLng
    private lateinit var locationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root


        val searchView = findViewById<Any>(R.id.barrabusqueda)
    }

    private fun <T> findViewById(searchView: T) {

    }

//    private val getmapa = OnMapReadyCallback{ googleMap ->
//        mmap = googleMap
//        localitation = LatLng(0.0, 0.0)
//        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
//        locationClient  = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!
//
//        googleMap.setMaxZoomPreference(0.5f)
//        googleMap.setMinZoomPreference(14.5f)
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//    val mapafragment = childFragmentManager.findFragmentById(R.id.MapFragment) as SupportMapFragment?
//        mapafragment?.getMapAsync(getmapa)

        val nav = findNavController()
//        val ubi = requireActivity().application as wheaterclass
//        val viem: ViewModel by activityViewModels(){
//            ViewModel.MyViewModelFactory(wheaterclass.repositorio)
//        }



    }

}





































































































































