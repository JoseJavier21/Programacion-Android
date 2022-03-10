package com.example.listados.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.listados.Equipo
import com.example.listados.databinding.ContenedorBinding

class EquipoHolder(val binding: ContenedorBinding): RecyclerView.ViewHolder(binding.root){

    fun setMyData(team: Equipo) {
        binding.textView.text = team.equipo
        binding.textView2.text = team.nombre
        binding.textView3.text = team.color
    }
}