package com.example.practica_valorant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_valorant.databinding.CeldaListBinding

class AdapterPerso(val personajes : List<Personaje>) : RecyclerView.Adapter<AdapterPerso.Celda>()
{

    inner class Celda(val binding : CeldaListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Celda {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =CeldaListBinding.inflate(layoutInflater, parent, false)
        return Celda(binding)
    }

    override fun onBindViewHolder(holder: Celda, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}