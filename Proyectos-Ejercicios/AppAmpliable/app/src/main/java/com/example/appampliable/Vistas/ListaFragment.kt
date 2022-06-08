package com.example.appampliable.Vistas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appampliable.Adapter.CircuitAdapter
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.ViewModel.ViewModel
import com.example.appampliable.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var adapter: CircuitAdapter


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val vm: ViewModel by activityViewModels{
            ViewModel.MyViewModelFactory(myApp.repositorio)
        }
        configRecycler(vm)

        vm.todoscircuitos.observe(viewLifecycleOwner){
            adapter.updateCircuitlist(it as ArrayList<TablaCircuit>)
        }


    }

    private fun configRecycler(vm: ViewModel) {
        adapter = CircuitAdapter(vm)
        binding.listaRV.layoutManager = LinearLayoutManager(requireContext())
        binding.listaRV.adapter = adapter
    }
}