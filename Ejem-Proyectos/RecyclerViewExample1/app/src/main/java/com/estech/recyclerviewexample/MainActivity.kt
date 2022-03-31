package com.estech.recyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estech.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jugadores = mutableListOf("Casillas", "Iniesta", "Villa", "Busquets", "Fernando Torres")
        jugadores.add("Xavi")
        jugadores.add("Capdevila")
        jugadores.add("Jesús Navas")
        jugadores.add("David Silva")

        val recyclerView = binding.recyclerview
        val llm = LinearLayoutManager(this)
        recyclerView.layoutManager = llm
        val adapter = MyAdapter(jugadores)
        recyclerView.adapter = adapter
    }
}