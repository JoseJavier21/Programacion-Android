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
        val usur = misPreferencias.getString("usur", "")
        val cont = misPreferencias.getString("cont", "")


//   CODIGO    //

        binding.acceder.setOnClickListener {
            val usuario = binding.usuario.text.toString()
            val contra = binding.contrasenia.text.toString()
            comprobacion(usuario, contra)
            if (comprobacion(usuario,contra)){  // REVISAR PARA HACER BIEN GUARDAR LOS DATOS

                val editor = misPreferencias.edit()
                editor.putString("usur", usur)
                editor.putString("cont", cont)
                editor.apply()

                startActivity(conte)
            }
        }

        binding.invitados.setOnClickListener {
            startActivity(conte)
            Toast.makeText(this, "Bienvenido invitado", Toast.LENGTH_SHORT).show()
        }

    }

    private fun comprobacion(usuario: String, contra: String) : Boolean{

            when{
                    // EN CASOS POSITIVOS

                    usuario == "aficionado" && contra == "123456"->{
                        Toast.makeText(this, "Bienvenido aficionado", Toast.LENGTH_SHORT).show()
                        return true

                    }

                    usuario == "jugador" && contra == "qwerasdf"->{
                        Toast.makeText(this, "Bienvenido jugador", Toast.LENGTH_SHORT).show()
                        return true
                    }

                    usuario == "directivo" && contra == "asdfasdf"->{
                        Toast.makeText(this, "Bienvenido directivo", Toast.LENGTH_SHORT).show()
                        return true
                    }

                    // EN CASO VACIO

                    usuario.isEmpty()->{
                        binding.usuario.error = "El campo esta vacio"

                        return false
                    }

                    contra.isEmpty()->{
                        binding.contrasenia.error = "El campo esta vacio"
                        return false
                    }

                    else->{
                        cuadrodiag()
                        return false
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


