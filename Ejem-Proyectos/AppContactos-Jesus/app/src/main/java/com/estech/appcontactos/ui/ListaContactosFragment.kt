package com.estech.appcontactos.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.estech.appcontactos.MyApp
import com.estech.appcontactos.R
import com.estech.appcontactos.databinding.ActivityMainBinding
import com.estech.appcontactos.databinding.FragmentListaContactosBinding
import com.estech.appcontactos.domain.models.Contacto
import com.estech.appcontactos.ui.Adapter.ListaContactoAdapter
import com.estech.appcontactos.viewmodel.MyViewModel


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class ListaContactosFragment: Fragment() {

    private lateinit var binding: FragmentListaContactosBinding
    private lateinit var adapter: ListaContactoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaContactosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val vm : MyViewModel by activityViewModels{
            MyViewModel.MyViewModelFactory(myApp.repository)
        }
        configRecycler(vm)

        vm.todosContactos.observe(viewLifecycleOwner){
            adapter.actualizarLista(it as ArrayList<Contacto>)
        }

        binding.floatActionbuttonAdd.setOnClickListener{
        findNavController().navigate(R.id.action_listaContactosFragment_to_fragmentAgregarForm)
            /* Otra forma de navegar entre fragment
            *  val fragment = FragmentAgregarForm()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()*/
            }
        binding.floatingActionButtonFavs.setOnClickListener {
            findNavController().navigate(R.id.action_listaContactosFragment_to_fragmentListaFav)
        }


        binding.floatActionbuttonRemove.setOnClickListener{
            vm.eliminarContactos()
        }
    }

    private fun configRecycler(vm : MyViewModel){
        adapter = ListaContactoAdapter(vm)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}