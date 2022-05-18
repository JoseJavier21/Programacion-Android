package com.estech.appcontactos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estech.appcontactos.databinding.FragmentAnadircontactoBinding
import com.estech.appcontactos.domain.models.TablaContact

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    var contactos: ArrayList<TablaContact> = ArrayList()

    inner class MovieHolder(val binding: FragmentAnadircontactoBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentAnadircontactoBinding.inflate(layoutInflater, parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = contactos[position]
        holder.binding.nombre.text = movie.nombre.toString()
        holder.binding.apellidos.text = movie.apellidos.toString()
        holder.binding.tlf.text = movie.telefono.toString()
        holder.binding.correo.text = movie.correoelectronico.toString()
        holder.binding.edad.text = movie.edad.toString()

    }

    override fun getItemCount(): Int {
        return contactos.size
    }

    fun updateUserList(arrayList: ArrayList<TablaContact>) {
        contactos.clear()
        contactos = arrayList
        notifyDataSetChanged()
    }
}