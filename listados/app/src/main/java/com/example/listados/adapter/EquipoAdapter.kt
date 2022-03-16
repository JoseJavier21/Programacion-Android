package com.example.listados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listados.Equipo
import com.example.listados.databinding.ContenedorBinding
import kotlin.text.toInt as toInt1

class EquipoAdapter(val lista: MutableList<Equipo>): RecyclerView.Adapter<EquipoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoHolder {
        val mostrar = LayoutInflater.from(parent.context)
        val vista = ContenedorBinding.inflate(mostrar, parent, false)
        val posicion = EquipoHolder(vista)
        return posicion
    }

    override fun onBindViewHolder(holder: EquipoHolder, position: Int) {
        val team = lista[position]
//        holder.binding.Txtv1.toString().toInt() = team.equipo
        holder.binding.Txtv2.text = team.nombre
        holder.binding.Txtv3.text = team.color

        // Boton de borrado
        holder.binding.borrar.setOnClickListener {
            deleteItem(position)
            true
        }
    }

    // Para eliminar elemetos de la lista
    fun deleteItem(position: Int){
        if (position < lista.size){
            lista.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,lista.size)
        }
    }

    // Longitud del listado
    override fun getItemCount(): Int {
        return lista.size
    }

}




