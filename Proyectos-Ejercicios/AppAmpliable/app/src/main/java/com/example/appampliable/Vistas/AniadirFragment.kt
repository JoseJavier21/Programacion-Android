package com.example.appampliable.Vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.appampliable.Adapter.CircuitAdapter
import com.example.appampliable.MyApp
import com.example.appampliable.R
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
        val viewMoel : ViewModel by activityViewModels{
            ViewModel.MyViewModelFactory(myApp.repositorio)
        }


    }


}