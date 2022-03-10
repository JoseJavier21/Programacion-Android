package com.example.listados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listados.Equipo
import com.example.listados.databinding.ContenedorBinding

class EquipoAdapter(val lista: MutableList<Equipo>): RecyclerView.Adapter<EquipoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoHolder {
        val mostrar = LayoutInflater.from(parent.context)
        val vista = ContenedorBinding.inflate(mostrar, parent, false)
        val posicion = EquipoHolder(vista)
        return posicion
    }

    override fun onBindViewHolder(holder: EquipoHolder, position: Int) {

        val team = lista[position]
        holder.setMyData(team)
    }

    override fun getItemCount() =lista.size

    fun addteam(team: Equipo) {
        lista.add(team)
        notifyDataSetChanged()
    }
}



