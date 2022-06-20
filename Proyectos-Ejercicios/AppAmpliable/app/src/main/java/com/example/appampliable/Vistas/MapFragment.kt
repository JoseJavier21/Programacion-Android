package com.example.appampliable.Vistas

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appampliable.R
import com.example.appampliable.databinding.FragmentMapBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding

    private val callback = OnMapReadyCallback { googleMap ->

        val rusia = LatLng(52.0, 213.0)
        googleMap.addMarker(MarkerOptions().position(rusia).title("Marcador en Rusia"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(rusia))
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
    }
}