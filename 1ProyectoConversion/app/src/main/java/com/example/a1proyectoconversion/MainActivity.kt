package com.example.a1proyectoconversion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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


    //  Convertidor de monedas  //




    }
}