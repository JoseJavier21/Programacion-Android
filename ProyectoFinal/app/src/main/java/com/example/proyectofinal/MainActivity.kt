package com.example.proyectofinal

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//   VARIABLES   //

        val usuario = binding.usuario.text.toString()
        val contra = binding.contrasenia.text.toString()
        val misPreferencias = getSharedPreferences("myprefs", MODE_PRIVATE)
        val editor = misPreferencias.edit()

//   CODIGO    //

        binding.acceder.setOnClickListener {
            comprobacion(usuario, contra)


        }

        binding.invitados.setOnClickListener {
            Toast.makeText(this, "hola invi", Toast.LENGTH_LONG).show()


        }



    }

    private fun comprobacion(usuario: String, contrasenia: String){

            when{
                    // EN CASOS POSITIVOS

                    usuario == "aficionado" && contrasenia == "123456"->{
                        Toast.makeText(this, "hola afi", Toast.LENGTH_LONG).show()

                    }

                    usuario == "jugador" && contrasenia == "qwerasdf"->{
                        Toast.makeText(this, "hola juga", Toast.LENGTH_LONG).show()
                    }

                    usuario == "directivo" && contrasenia == "asdfasdf"->{
                        Toast.makeText(this, "hola dire", Toast.LENGTH_LONG).show()
                    }

                    // EN CASO VACIO

                    usuario.isEmpty()->{
                        binding.usuario.error = "El campo esta vacio"
                    }

                    contrasenia.isEmpty()->{
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


