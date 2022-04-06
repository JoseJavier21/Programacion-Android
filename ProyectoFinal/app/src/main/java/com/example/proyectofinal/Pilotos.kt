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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val algo = listOf(R.drawable.cicuito1,
            R.drawable.cicuito2,
            R.drawable.circuit3,
            R.drawable.circuit4)
        val adapter = AdapterGalery(algo)
        binding.recyclerView.adapter = adapter

    }
}