package com.estech.appcontactos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.estech.appcontactos.MyApp
import com.estech.appcontactos.databinding.FragmentAnadircontactoBinding
import com.estech.appcontactos.databinding.FragmentListaContactosBinding
import com.estech.appcontactos.domain.models.TablaContact
import com.estech.appcontactos.viewmodel.MyViewModel


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class ListaContactosFragment: Fragment() {

    private lateinit var binding: FragmentListaContactosBinding
    private lateinit var movieAdapter: MovieAdapter

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

        val MyApp = requireActivity().application as MyApp
        val view: MyViewModel by activityViewModels{
            MyViewModel.MyViewModelFactory(MyApp.repository)
        }

        val adapter = MovieAdapter()
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        view.todosContactos.observe(viewLifecycleOwner){
            adapter.updateUserList(it as ArrayList<TablaContact>)
        }

        binding.aniadir.setOnClickListener {
            val contact  = TablaContact(
                "jose",
                "rojo",
                3,
                "josee",
                23,
                false
            )

            view.insertContact(contact)
        }

        binding.delete.setOnClickListener {

        }

    }
}