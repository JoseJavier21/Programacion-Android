package com.example.weatherapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.WheaterApp
import com.example.weatherapp.databinding.CeldaBinding
import com.example.weatherapp.modelo.Tiempo

class Adapter(val cambios: ArrayList<Tiempo>): RecyclerView.Adapter<Adapter.celda>(), Filterable{

    inner class celda(val binding: CeldaBinding): RecyclerView.ViewHolder(binding.root)

    val posicion = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): celda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaBinding.inflate(layoutInflater, parent, false)
        return celda(binding)
    }

    override fun onBindViewHolder(holder: celda, position: Int) {

        posicion = holder.adapterPosition
        val binding = holder.binding
        val sunny = cambios[posicion]

        val viemodel = ViewModel(WheaterApp.repositorio)

        binding.tempcelda.text = sunny.tiempo.toString()
        binding.fechacelda.text = sunny.localTime
        binding.tiempocelda.text = sunny.timezone
        binding.iconcelda.setImageURI(sunny.imagen?.toUri())


    }

    override fun getItemCount(): Int {
        return cambios.size
    }



    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val palabraABuscar = p0.toString()

                if (palabraABuscar.isEmpty()) {
                    cambios = cambios
                } else {
                    cambios = cambios.filter {
                        (it.name.lowercase().contains(palabraABuscar.lowercase()) ||
                                it.types.toString().lowercase().contains(palabraABuscar.lowercase()))
                    } as ArrayList<Resultado.Data>
//                    listaCopia = listaApoyo as ArrayList<Resultado.Data>
                }
                val filterResults = FilterResults()
                filterResults.values = listaCopia
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                cambios = p1?.values as ArrayList<Tiempo.Data>
                notifyDataSetChanged()
            }

        }
    }


}