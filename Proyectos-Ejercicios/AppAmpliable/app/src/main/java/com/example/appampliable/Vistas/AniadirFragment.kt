package com.example.appampliable.Vistas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appampliable.Adapter.CircuitAdapter
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.databinding.FragmentAniadirBinding

class AniadirFragment : Fragment() {

    private lateinit var binding: FragmentAniadirBinding
    private lateinit var adapter: CircuitAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAniadirBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val viem: ViewModel by activityViewModels{
            ViewModel.MyViewModelFactory(myApp.repositorio)
        }
        binding.addpoint.setOnClickListener {
            val nombre = binding.nombrecircuito.text.toString()
            val ciudad = binding.nombreciudad.text.toString()
            val pais = binding.nombrepais.text.toString()
            val numero = binding.mas
            val valoracion = binding.valoracion.text.toString()
            val pregunta = false


            if(nombre.isNotEmpty() && ciudad.isNotEmpty() && pais.isNotEmpty()){
                val circuitos = TablaCircuit(
                    nombre,
                    ciudad,
                    pais
                )
                viem.insertCircuito(circuitos)
                findNavController().navigate(R.id.action_aniadirFragment_to_listaFragment)
            }

        }

    }


}