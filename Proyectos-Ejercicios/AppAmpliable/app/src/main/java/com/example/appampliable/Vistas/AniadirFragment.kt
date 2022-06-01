package com.example.appampliable.Vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.appampliable.MyApp
import com.example.appampliable.R

class AniadirFragment : Fragment() {

    private lateinit var binding: AniadirFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aniadir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val viewModel : ViewModel by activityViewModels{
            ViewModel.MyViewModelFactory(myApp.repositorio)
        }
    }
}