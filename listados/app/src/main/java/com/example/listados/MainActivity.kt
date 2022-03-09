package com.example.listados

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.listados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }


    val equipo1 = Equipo("Mclaren", "Carlos Sainz", "naranja")
    val equipo2 = Equipo("RedBull", "Verstappen", "Azul")
    val equipo3 = Equipo("Mercedes", "Hamilton", "Verde")
    val equipo4 = Equipo("Ferrari", "Leclert", "Rojo")
    val equipo5 = Equipo("Alfa-Romeo", "Hass", "Rosa")



}


