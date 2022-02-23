package com.example.a1proyectoconversion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ActionBarContextView
import com.example.a1proyectoconversion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //      Boton para compartir      //

        binding.compartir.setOnClickListener {

            if (binding.compartir.isClickable) {
                try {
                    val uri = Uri.parse("twitter://user?screen_name=escuelaestech")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                } catch (e: Exception) {
                    val uri = Uri.parse("https://twitter.com/escuelaestech")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "No toques mas", Toast.LENGTH_SHORT).show()
            }
        }


        //  Convertidor de monedas  //

//        val monedas = ArrayAdapter.createFromResource(this, R.array.monedas_juegos, android.R.layout.simple_spinner_item)

        val monedas = resources.getStringArray(R.array.monedas_juegos)
        val adapterUsuarios = ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            monedas
        )


//        Prueba de funcionamiento de spinner


        val primero: Spinner = findViewById(R.id.spinner1)

        // crea un arrayadaptter usando un string de array
        ArrayAdapter.createFromResource(
            this,
            R.array.monedas_juegos,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            // indica donde va a ir el spinner
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // aplica el adapter al spinner
            primero.adapter = adapter
        }

        val segundo: Spinner = findViewById(R.id.spinner2)

        ArrayAdapter.createFromResource(
            this,
            R.array.monedas_juegos,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            segundo.adapter = adapter
        }

        binding.convertir.setOnClickListener {

            val primero = binding.spinner1.selectedItemPosition
            val segundo = binding.spinner2.selectedItemPosition
            val resultado: Int

            if (primero == 0) {
                when (segundo) {
                    1 -> 1.25 * 2
//                    2-> 0.75 * monedas a elegir
//                    3-> 0.95 * monedas a elegir
//                    4-> 1.75 * monedas a elegir
//                    5-> 0.25 * monedas a elegir

                }
            }
        }
    }

}