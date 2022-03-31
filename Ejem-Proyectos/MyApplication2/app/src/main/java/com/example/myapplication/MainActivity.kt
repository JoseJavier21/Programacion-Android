package com.example.myapplication

import android.app.Person
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dataclass.Persona

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val persona = Persona("SErgio", "Velasco", 33)
        val dni = persona.Dni(23235, 'L')

        dni.letra

        val hermano = Persona("Alvaro", 25, persona)
        persona.apellidos = "Quesada"
        //Toast.makeText(this, persona.imprimirNombre(), Toast.LENGTH_SHORT).show()

        val persona2 = Persona("SErgio", "Velasco", 35)

        val listaPErsona = mutableListOf<Any>(persona, hermano, persona2, 234234, "Sergio")
        if (listaPErsona[0] is Persona) {

        }

        //Toast.makeText(this, Sergio.toString(), Toast.LENGTH_SHORT).show()

        Constants.crearToast("hola", this)
        Constants.crearAlertDialog("Hola", this)

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constants.PARAM_NOMBRE, "loque sea")
        startActivity(intent)

        val textView = TextView(this)
        textView.text = "Hola"

    }

    val Sergio = object  {
        val nombre = "Sergio"
        val apellidos = "Velasco"
        override fun toString(): String {
            return "$nombre $apellidos"
        }
    }
}