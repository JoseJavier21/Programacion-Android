package com.estech.locationsample

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.estech.locationsample.databinding.ActivityMainBinding
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var locationClient: FusedLocationProviderClient
    private lateinit var binding: ActivityMainBinding
    private var tipoPermiso = 1
    private lateinit var locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationClient = LocationServices.getFusedLocationProviderClient(this)

        binding.button1.setOnClickListener {
            tipoPermiso = 1
                pedirPermisosUbicacion()
        }
        binding.button2.setOnClickListener {
            tipoPermiso = 2
                pedirPermisosUbicacion()
        }
    }

    /**
     * Función para obtener la última ubicación conocida
     */
    private fun mostrarUbicacion() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationClient.lastLocation.addOnSuccessListener {
            if (it != null)
                imprimirUbicacion(it)
        }
    }

    private fun prepararUbicacionEnDirecto() {
        locationRequest = LocationRequest.create()
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 2500
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val locationSettingsBuilder =
            LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        val settingsClient = LocationServices.getSettingsClient(this)
        val task = settingsClient.checkLocationSettings(locationSettingsBuilder.build())
        task.addOnSuccessListener {
            tomarUbicacionEnDirecto()
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                try {
                    val intentSenderRequest =
                        IntentSenderRequest.Builder(exception.resolution).build()
                    contract.launch(intentSenderRequest)
                } catch (throwable: Throwable) {
                    // Ignore the error.
                }
            }
        }


    }

    val contract = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
        if (it.resultCode == RESULT_OK) {
            tomarUbicacionEnDirecto()
        } else {
            // No se puede tomar la ubicación con la configuración actual
        }
    }



    /**
     * Función para obtener la ubicación de forma periódica
     */

    private fun tomarUbicacionEnDirecto() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationClient.requestLocationUpdates(locationRequest, locationCallback,
            Looper.getMainLooper()
        )
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {
            for (location in p0.locations) {
                imprimirUbicacion(location)
            }
            val lastLocation = p0.lastLocation
            imprimirUbicacion(lastLocation)
        }
    }



    /**
     * Función que recibe una instancia de Location e imprime ciertos atributos de la instancia
      */
    private fun imprimirUbicacion(location: Location) {

        val latitud = location.latitude
        val longitud = location.longitude
        val altitud = location.altitude
        val precision = location.accuracy
        val proveedor = location.provider
        val bearing = location.bearing
        val timeStamp = location.time

        val sdf = SimpleDateFormat("yyyy/MM/dd - HH:mm:ss", Locale.getDefault())
        val time = sdf.format(Date(timeStamp))

        val message = """
            Latitud: $latitud, Longitud: $longitud
            Altitud: $altitud
            Accuracy: $precision
            Proveedor: $proveedor
            Orientación: $bearing
            Fecha/Hora : $time
            """

        binding.textview.text = message
    }

    /****************FUNCIONES PARA PEDIR PERMISO AL USUARIO *******************************/

    /**
     * función para calcular si una lista de permisos está aceptada
     */
    private fun isPermissionsGranted(list: Array<String>): Int {
        // PERMISSION_GRANTED : Constant Value: 0
        // PERMISSION_DENIED : Constant Value: -1
        var counter = 0
        for (permission in list) {
            counter += ContextCompat.checkSelfPermission(this, permission)
        }
        return counter
    }

    /**
     * Función para pedir permisos
     *  - Si ya fueron aceptados, muestra ubicación o prepara ubicación en directo según el botón pulsado
     *  - Si el usuario los rechazó una vez, se muestra un cuadro de diálogo explicativo
     *  - Si no se han aceptado los permisos, se pide autorización al usuario
     */
    private fun pedirPermisosUbicacion() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            if (tipoPermiso == 1) mostrarUbicacion()
            else prepararUbicacionEnDirecto()

        } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            showAlertDialog()
        } else {
            somePermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    /**
     * Contrato con el resultado del usuario al solicitar permisos
     *  - si no hay ningún valor falso es que todos fueron aceptados, por lo que se llama a la función correspondiente
     *  - Si se encuentra algún valor falso, no se han aceptado todos los permisos
      */
    private val somePermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (!it.containsValue(false)) {
            //todos los permisos aceptados
            if (tipoPermiso == 1) mostrarUbicacion()
            else prepararUbicacionEnDirecto()
        } else {
            // al menos un permiso no se ha aceptado
            Toast.makeText(this, "No se han aceptado los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Cuadro de diálogo para explicar de forma más extendida los permisos al usuario
     */
    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Los permisos de ubicación permitirán ver tu ubicación en el mapa. Los creadores no almacenan esta información en ningún lugar")
        builder.setNegativeButton("Rechazar", null)
        builder.setPositiveButton("Aceptar") { dialog, position ->
            somePermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
        builder.create().show()
    }


    override fun onPause() {
        super.onPause()
        // esta función sirve para detener el callback de ubicación periódica
        locationClient.removeLocationUpdates(locationCallback)
    }

    override fun onResume() {
        super.onResume()
        // si locationRequest ya ha sido inicializado, podemos hacer que al volver la aplicación de
        // un onPause, siga tomando la ubicación en directo
        if (this::locationRequest.isInitialized) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            locationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
        }
    }
}