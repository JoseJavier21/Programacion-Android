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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//   VARIABLES   //

        val conte = Intent(this, Contenedor::class.java)
        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)




//   CODIGO    //


        binding.acceder.setOnClickListener {
            val usuario = binding.usuario.text.toString()
            val contra = binding.contrasenia.text.toString()
            comprobacion(usuario, contra)

            if (comprobacion(usuario,contra) != null){
                intent.putExtra("usur", "usuario")
                intent.putExtra("cont", "contra")
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
                    }

                    usuario == "jugador" && contra == "qwerasdf"->{
                    }

                    usuario == "directivo" && contra == "asdfasdf"->{
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


