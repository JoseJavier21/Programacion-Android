package com.example.listados.adapter

class Equipoadapter(val listado: Mutablelist<Equipo>): RecyclerVIew.Adapter<EquipoHolder>(){

    override fun onCreateVIewHolder(){

        val layout.inflater = LayoutInflater.from(parent.context)
        val binding = ContenedorBinding.inflate(layoutInflater, parent, false)
        return equipoHolder(binding)
    }

    override fun onBinViewHolder(){

        val equipo = listado[position]
        holder.setMyData(jugador)

        holder.binding.holderName.text = jugador.nombre
    }

    override fun getItemCount() = listado.size


}