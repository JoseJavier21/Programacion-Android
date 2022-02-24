package com.example.a1proyectoconversion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.a1proyectoconversion.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    //      Diferentes variables de las monedas     //

        val aros = 6
        val banana = 2
        val creditos = 4
        val gil = 3
        val rupia = 5
        val monedaoro = 1


    //      Boton modo oscuro       //

        binding.modo.setOnClickListener {

            val myCheckBox = findViewById<Chip>(R.id.modo)
            myCheckBox.setOnCheckedChangeListener { compoundButton, isChcked ->
                // cambiar layout al que esta en modo oscuro
            }
        }


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

        binding.convertir.setOnClickListener {

           val divisa1 = binding.primeramoneda.text.toString().toDouble()

           val guardar = convertir(binding.spinner1.selectedItemPosition)
           val guardar2 = convertir(binding.spinner2.selectedItemPosition)

           val cuenta = guardar * divisa1 * guardar2

        binding.resultado.text = cuenta.toString()

        }
   }


    // Funcion para coger las variables     //

    fun convertir(lugar:Int): Int {
        when (lugar){

            0 -> {val num = 1
                    return num}
            1 -> {val num = 5
                    return num}
            2 -> {val num = 4
                    return num}
            3 -> {val num = 3
                    return num}
            4 -> {val num = 6
                    return num}
            5 -> {val num = 2
                    return num}
            else -> {val num = 0
                    return num}
        }
    }

    //  Para cambiar imagen moneda       //




}