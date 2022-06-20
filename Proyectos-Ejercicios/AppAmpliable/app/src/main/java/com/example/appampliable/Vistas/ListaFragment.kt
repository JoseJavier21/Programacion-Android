package com.example.appampliable.Vistas

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.TokenWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appampliable.Adapter.CircuitAdapter
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.ViewModel.ViewModel
import com.example.appampliable.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var circuitoslista: ArrayList<TablaCircuit>
    private lateinit var adapter: CircuitAdapter


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navi = findNavController()
        val myApp = requireActivity().application as MyApp
        val viem: ViewModel by activityViewModels{
            ViewModel.MyViewModelFactory(myApp.repositorio)
        }

        binding.borrar.setOnClickListener {
            if(viem.todoscircuitos.value!!.isNotEmpty()){
                viem.delete()
                adapter.updateCircuitlist(circuitoslista)
                Toast.makeText(context, "Ya esta todo borrado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "La lista contiene circuitos revisa", Toast.LENGTH_LONG).show()
            }
        }

        binding.botonmapa.setOnClickListener {
            navi.navigate(R.id.action_listaFragment_to_mapaFragment)
        }

        binding.crearpunto.setOnClickListener {
            findNavController().navigate(R.id.action_listaFragment_to_aniadirFragment)
        }
        
        configRecycler()
    }

    private fun configRecycler() {
        adapter = CircuitAdapter(requireContext(),circuitoslista)
        binding.listaRV.layoutManager = LinearLayoutManager(requireContext())
        binding.listaRV.adapter = adapter
    }
}