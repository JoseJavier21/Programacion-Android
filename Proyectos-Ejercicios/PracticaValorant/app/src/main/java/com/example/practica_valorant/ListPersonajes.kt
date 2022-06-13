package com.example.practica_valorant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.practica_valorant.databinding.FragmentListPersonajesBinding
import com.example.practica_valorant.modelos.Valorant
import com.google.gson.Gson
import org.json.JSONException
import java.io.InputStream


class ListPersonajes : Fragment() {

    private lateinit var binding: FragmentListPersonajesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = FragmentListPersonajesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val jsonEnString = getJsonAsset()

        if (jsonEnString != null) {
            val gson = Gson()
            val listapersonajes = gson
                .fromJson(jsonEnString,Array<Valorant>::class.java).asList()
            configRecycler(listapersonajes)
        }
    }

    private fun getJsonAsset(): String? {
        var jsonString: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("valorant.json")
            jsonString = inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (e : JSONException) {
            Toast.makeText(requireContext(), "no funciona", Toast.LENGTH_LONG).show()
        }
        return jsonString
    }

    private fun configRecycler(listaPersonajes: List<Valorant>)
    {
        val recyclerView = binding.recycleView
        val adapter = AdapterPerso(listaPersonajes as ArrayList<Valorant>)
        val layoutManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL
        )
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}