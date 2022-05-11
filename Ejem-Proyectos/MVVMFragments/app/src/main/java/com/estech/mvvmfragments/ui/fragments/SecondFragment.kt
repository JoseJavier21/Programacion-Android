package com.estech.mvvmfragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.estech.mvvmfragments.databinding.FragmentAniadirBinding
import com.estech.mvvmfragments.viewmodel.JugadoresViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentAniadirBinding
    private val jugadoresViewModel: JugadoresViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAniadirBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            addPlayer()
            findNavController().popBackStack()}
    }

    private fun addPlayer() {
        val name = binding.editTextName.text.toString()
        val position = binding.editTextTextPosicion.text.toString()
        val number = binding.editTextDorsal.text.toString()

        jugadoresViewModel.addJugador(name, position, number)

    }
}