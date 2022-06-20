package com.example.appampliable.Vistas

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appampliable.Adapter.CircuitAdapter
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.databinding.FragmentAniadirBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class AniadirFragment : Fragment() {

    private lateinit var binding: FragmentAniadirBinding
    private var otorgar = PackageManager.PERMISSION_GRANTED
    private var localizacionpermiso = Manifest.permission.ACCESS_COARSE_LOCATION
    private lateinit var location: FusedLocationProviderClient
    private lateinit var mapa : GoogleMap
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
        binding = FragmentAniadirBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private var llamadamapas = OnMapReadyCallback{
        googleMap -> mapa = googleMap
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        coordendascero = LatLng(0.0, 0.0)
        location = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!
        Permisosrevision(googleMap)

        googleMap.setOnMapClickListener {
            googleMap.addMarker(MarkerOptions().position(it))
            coordendascero = it
            val longitud = coordendascero.longitude.toInt()
            val latitud =  coordendascero.latitude.toInt()
            binding.addpoint.text = "${longitud},${latitud}"
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navi = findNavController()
        val myApp = requireActivity().application as MyApp
//        val viem: ViewModel by activityViewModels{
//            ViewModel.MyViewModelFactory(myApp.repositorio)
//        }
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment?
        mapFragment?.getMapAsync(llamadamapas)


        binding.addpoint.setOnClickListener {
            view.insertCircuito(
                TablaCircuit(
                    binding.nombrecircuito.text.toString(),
                    binding.nombreciudad.text.toString(),
                    binding.nombrepais.text.toString(),
                    binding.valoracion.text.toString(),
//                    binding.checkBox.isChecked,
                )
            )
            navi.navigate(R.id.listaFragment)
        }

        binding.addimagen.setOnClickListener {
            hacerfoto()
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

    private fun Permisosrevision(googleMap: GoogleMap){
        Permisos(googleMap)
        if (!Permisos(googleMap)){
            ubicacionPermissionLauncher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION ))
        }
    }

    private fun permiso(context: Context, permission: String): Int {
        return ActivityCompat.checkSelfPermission(context,permission)
    }


    private val ICamara = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSaved ->
        if (isSaved) {
           Toast.makeText(requireContext(), "Esta guardada", Toast.LENGTH_LONG).show()
        }
        else{
            val Archivo = requireActivity().getExternalFilesDir("/Imagenes/" + cam.path)
            Archivo?.let {Archivo.delete()}
        }

    }

    private fun hacerfoto() {
        val archivoFoto =  crearArchivoParaFoto()
        cam = FileProvider.getUriForFile(requireContext() ,"${requireActivity().packageName}.fotos", archivoFoto)
        ICamara.launch(cam)
    }

    private fun crearArchivoParaFoto(): File {
        val timeStamp: String =SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_",".jpg", storageDir)
    }
}