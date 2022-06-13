package com.example.practica_valorant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.practica_valorant.databinding.ActivityMainBinding
import com.example.practica_valorant.databinding.FragmentInfoPersonajBinding
import com.example.practica_valorant.modelos.Valorant


class InfoPersonaj : Fragment() {

    private lateinit var binding: FragmentInfoPersonajBinding

    override fun onCreateView(
        inflater : LayoutInflater,container : ViewGroup?,savedInstanceState : Bundle?
    ) : View?
    {
        binding = FragmentInfoPersonajBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personaje : Valorant? = arguments?.getParcelable("valorant")
        if (personaje != null){
            (requireActivity() as MainActivity).supportActionBar?.title = personaje.description
            binding.nombrepersoj.text = personaje.description
            Glide.with(this).load(personaje.dispayName).into(binding.imageView)
        }
    }
}