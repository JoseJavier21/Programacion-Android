package com.example.variaspaginas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class Segundactividad : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dos)

        val nombre = findViewById<TextView>(R.id.nombre)
        val importe = findViewById<TextView>(R.id.importe)
        val cambioinver = findViewById<Button>(R.id.cambiodeinversion)
        val mensaje = findViewById<FloatingActionButton>(R.id.mensaje)
        val addresses = arrayOf("jose.jrf2000@gmail.com")
        val subject = "Asunto"
        val text = "Texto"



        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(intent)




        onCreate(
            val b = getIntent().extras
            val correo = b!!.getString("email")
            val contra = b!!.getString("password")
        )
    }
}