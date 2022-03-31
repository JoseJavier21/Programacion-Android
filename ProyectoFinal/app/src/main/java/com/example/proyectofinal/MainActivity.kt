package com.example.proyectofinal

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import com.example.proyectofinal.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//   VARIABLES   //


        val conte = Intent(this, Contenedor::class.java)
        //minavegacion
        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val editor = misPreferencias.edit()



//   CODIGO    //


        binding.acceder.setOnClickListener {
            val usuario = binding.usuario.text.toString()
            val contra = binding.contrasenia.text.toString()
            comprobacion(usuario, contra)

            if (comprobacion(usuario, contra) != null){
                startActivity(conte)
            }
        }

        binding.invitados.setOnClickListener {

            startActivity(conte)



        }

    }

    private fun comprobacion(usuario: String, contra: String){

            when{
                    // EN CASOS POSITIVOS

                    usuario == "aficionado" && contra == "123456"->{
                        Toast.makeText(this, "hola afi", Toast.LENGTH_LONG).show()

                    }

                    usuario == "jugador" && contra == "qwerasdf"->{
                        Toast.makeText(this, "hola juga", Toast.LENGTH_LONG).show()
                    }

                    usuario == "directivo" && contra == "asdfasdf"->{
                        Toast.makeText(this, "hola dire", Toast.LENGTH_LONG).show()
                    }

                    // EN CASO VACIO

                    usuario.isEmpty()->{
                        binding.usuario.error = "El campo esta vacio"
                    }

                    contra.isEmpty()->{
                        binding.contrasenia.error = "El campo esta vacio"
                    }

                    else->{
                        cuadrodiag()
                    }
            }
    }

        private fun cuadrodiag(){

            val builder = AlertDialog.Builder(this)

            builder.setTitle("Mensaje de error")
            builder.setMessage("Fallo al introducir los datos")
            builder.setNegativeButton("OK", null)
            val dialog = builder.create() //AlertDialog
            dialog.show()
        }

}


