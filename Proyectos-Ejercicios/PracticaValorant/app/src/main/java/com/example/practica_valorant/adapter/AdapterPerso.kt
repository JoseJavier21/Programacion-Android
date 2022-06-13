package com.example.practica_valorant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica_valorant.databinding.CeldaListBinding
import com.example.practica_valorant.modelos.Valorant

class AdapterPerso(val personajes: ArrayList<Valorant>): RecyclerView.Adapter<AdapterPerso.Celda>()
{
    inner class Celda(val binding : CeldaListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Celda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =CeldaListBinding.inflate(layoutInflater, parent, false)
        return Celda(binding)
    }

    override fun onBindViewHolder(holder: Celda, position: Int) {

        val personaje : Valorant = personajes.get(position)
        holder.binding.nombreper.text = personaje.nombrePersonaje

        Glide.with(holder.itemView).load(personaje.image).into(holder.binding.renderperso)
        Glide.with(holder.itemView).load(personaje.species).into(holder.binding.nombreper)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("personaje" to personaje)
            val navigation = holder.itemView.findNavController()
            navigation.navigate(R.id.action_listPersonajes_to_infoPersonaj, bundle)
        }


    }

    override fun getItemCount(): Int {
        return personajes.size
    }
}