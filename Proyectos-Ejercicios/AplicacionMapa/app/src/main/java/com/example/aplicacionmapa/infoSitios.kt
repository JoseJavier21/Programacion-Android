package com.example.aplicacionmapa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.aplicacionmapa.databinding.FragmentInfoSitiosBinding
import com.example.aplicacionmapa.datamaps.MapasItem


class infoSitios : Fragment() {

    private lateinit var binding: FragmentInfoSitiosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoSitiosBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "se cambio de fragment", Toast.LENGTH_SHORT).show()

        val lugares: MapasItem? = arguments?.getParcelable("name")
        if (lugares != null){
            (requireActivity() as MainActivity).supportActionBar?.title = lugares.name
            binding.nombre.text = lugares.name
        Glide.with(this).load(lugares.image).into(binding.fotomonu)
        }

    }

}