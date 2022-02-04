package com.example.ejercicioprackotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMas = findViewById<Button>(R.id.mas)
        val buttonMenos = findViewById<Button>(R.id.menos)
        val camNumero = findViewById<EditText>(R.id.cambiarnumero)
        val resultadopri = findViewById<TextView>(R.id.resultado)
        val switchvisible = findViewById<Switch>(R.id.switch1)



        //Procesos para boton +1
        buttonMas.setOnClickListener {
            val numeroString = resultadopri.text.toString() // cambiar una variable a string
            var numerorojo = numeroString.toInt() //canbiamos esa variable a un numero entero
            val cambiarNumero = camNumero.text.toString() // ponemos como texto en cambiar numero

            if (cambiarNumero.isEmpty()){
                numerorojo++ // contador que suma 1
                resultadopri.text = numerorojo.toString() // ponemos el resultado en el textView
            }else{
                val cambiarnumerotoInt = cambiarNumero.toInt() //cambiamos el numero a entero
                val resultado = cambiarnumerotoInt + numerorojo // resultado a cambiar numero
                resultadopri.text = resultado.toString() // ponemos el resultado en el textrView
            }
        }

        //Procesos para boton -1

        buttonMenos.setOnClickListener{
            val numeroString = resultadopri.text.toString()
            var numerorojo = numeroString.toInt()
            val cambiarnumero = camNumero.text.toString()

            if (cambiarnumero.isEmpty()){
                numerorojo-- // contador para restar 1
                resultadopri.text = numerorojo.toString()
            }else{
                val cambiarnumeroInt = cambiarnumero.toInt()
                val resultado = numerorojo - cambiarnumeroInt
                resultadopri.text = resultado.toString()
            }
        }

        switchvisible.setOnClickListener{
            
        }


    }
}