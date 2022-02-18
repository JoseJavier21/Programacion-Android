package com.example.a1proyectoconversion

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.a1proyectoconversion.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    //      Boton para compartir      //


        binding.compartir.setOnClickListener {

            try {
                val uri = Uri.parse("twitter://user?screen_name=escuelaestech")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } catch (e: Exception) {
                val uri = Uri.parse("https://twitter.com/escuelaestech")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }


    //      Primer eleccion de moneda        //

        val monedaoro = 1
        val rupia = 5
        val credito = 2
        val gil = 4
        val aro = 6
        val banara =  3
        binding.spinner1.setOnClickListener {


        }


    //      Cambiar icono de moneda     //




    }
}