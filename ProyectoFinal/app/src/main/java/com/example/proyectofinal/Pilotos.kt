package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.databinding.FragmentPilotosBinding

class Pilotos : Fragment() {

    private lateinit var binding: FragmentPilotosBinding
    private lateinit var adapter: ListaPilotos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPilotosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val piloto1 = ListaPilotos("Fernando alonso", 12, "España")
        val pilot = mutableListOf(piloto1)
//
//        val recyclerView = binding.recyclerView
//        val llm = LinearLayoutManager(this)
//        recyclerView.layoutManager = llm
//        adapter = ListaPilotos(pilot)
//        recyclerView.adapter = adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}