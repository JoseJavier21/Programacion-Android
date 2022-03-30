package com.example.proyectofinal

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

        val usuario = binding.usuario
        val contrasenia = binding.contrasenia


        binding.acceder.setOnClickListener {

            if(usuario.editableText.isEmpty() && contrasenia.editableText.isEmpty()){
                usuario.setError("Campo vacio")
                contrasenia.setError("Campo vacio")

            }else if(usuario){

            }else{}


        }


    }
}