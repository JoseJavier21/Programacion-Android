package com.estech.gatosmvvm.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.estech.gatosmvvm.databinding.FragmentInfoBinding
import com.estech.gatosmvvm.modelos.listagatos.Breed
import com.estech.gatosmvvm.viewmodels.GatoViewmodel

class InfoFragment : Fragment() {

    private var breed: Breed? = null
    private lateinit var binding: FragmentInfoBinding
    private val gatosVm : GatoViewmodel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        gatosVm.razaSelecter.observe(viewLifecycleOwner){
            binding.weight.text = "${it!!.weight?.metric} Kg"
            binding.temperament.text = it.temperament
            binding.origin.text = "${it.origin} ${it.countryCode}"
            binding.lifespan.text = it.lifeSpan
            binding.description.text = it.description
        }
    }
}