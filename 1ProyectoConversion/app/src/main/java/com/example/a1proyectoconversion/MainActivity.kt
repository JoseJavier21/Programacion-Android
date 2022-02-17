package com.example.a1proyectoconversion

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val divisa1 = findViewById<EditText>(R.id.primeramoneda)
        val divisa2 = findViewById<EditText>(R.id.segundamoneda)
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val convertidor = findViewById<Button>(R.id.convertir)
        val resultado = findViewById<TextView>(R.id.resultado)
        val compartir = findViewById<FloatingActionButton>(R.id.compartir)




        compartir.setOnClickListener {

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


    }
}