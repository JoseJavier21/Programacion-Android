package com.example.appampliable.Vistas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.appampliable.MyApp
import com.example.appampliable.R
import com.example.appampliable.Room.CircuitDataBase
import com.example.appampliable.Room.CircuitInterface
import com.example.appampliable.Room.Repositorio
import com.example.appampliable.ViewModel.ViewModel

class ListaFragment : Fragment() {

    private lateinit var binding: ListaFragment


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.id.listaFragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myApp = requireActivity().application as MyApp
        val viewMoel : ViewModel by activityViewModels{


        }
    }
}