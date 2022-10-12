package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.CeldaBinding
import com.example.weatherapp.modelo.Tiempo

class Adapter(var cambios: MutableList<String>): RecyclerView.Adapter<Adapter.celda>(), Filterable{

    inner class celda(val binding: CeldaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): celda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaBinding.inflate(layoutInflater, parent, false)
        return celda(binding)
    }

    override fun onBindViewHolder(holder: celda, position: Int) {
        val lista: Tiempo.forecast = cambios.get(position)

    }

    override fun getItemCount(): Int {
        return cambios.size
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val buscar = p0.toString()

                if (buscar.isEmpty()) {
                    cambios = cambios
                } else {
                    cambios = cambios.filter {
                        (it.country?.lowercase()!!.contains(buscar.lowercase()) ||
                                it.country.toString().lowercase().contains(buscar.lowercase()))
                    } as ArrayList<Tiempo.forecast>
                }
                val filterResults = FilterResults()
                filterResults.values = cambios
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                cambios = p1?.values as ArrayList<Tiempo.forecast>
                notifyDataSetChanged()
            }

        }
    }


}