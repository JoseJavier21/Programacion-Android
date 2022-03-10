package com.example.listados

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listados.adapter.EquipoAdapter
import com.example.listados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val equipo1 = Equipo("Mclaren", "Carlos Sainz", "naranja")
        val equipo2 = Equipo("RedBull", "Verstappen", "Azul")
        val equipo3 = Equipo("Mercedes", "Hamilton", "Verde")
        val equipo4 = Equipo("Ferrari", "Leclert", "Rojo")
        val equipo5 = Equipo("Alfa-Romeo", "Hass", "Rosa")

        val equipos = mutableListOf(equipo1,equipo2,equipo3,equipo4,equipo5)

//        val columnas = GridLayoutManager(this, 3)
//        val llamada = LinearLayoutManager(this)


        val llamada = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = llamada
        val adapter = EquipoAdapter(equipos)
        binding.recyclerView.adapter = adapter


        binding.mas.setOnClickListener {

        }
    }
}


