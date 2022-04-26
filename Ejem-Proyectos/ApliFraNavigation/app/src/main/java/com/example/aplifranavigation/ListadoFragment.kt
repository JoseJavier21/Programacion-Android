package com.example.aplifranavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListadoFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false)
    }

    val equipo1 = Equipo(12, "Carlos Sainz", "naranja")
    val equipos = mutableListOf(equipo1)



    val recyclerView = binding.recyclerView
    val llm = LinearLayoutManager(this)
    recyclerView.layoutManager = llm
    adapter = EquipoAdapter(equipos)
    recyclerView.adapter = adapter


    // Boton para ir a la actividad para rellenar los datos
    binding.relleno.setOnClickListener {
        getResult.launch(Intent(this, SegundaActivity::class.java))
    }

    // Para borrar elementos del listado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.deleteall -> {
                adapter.lista.clear()
                adapter.notifyDataSetChanged()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


    // Para recoger los datos de la otra actividad y poder usarlos en esta
    val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { datos ->
        var result_datos = 3;

        when (datos.resultCode){

            result_datos->{

                val team1 = datos.data?.getIntExtra("equipo", 0)
                val name = datos.data?.getStringExtra("nombre")
                val col = datos.data?.getStringExtra("color")
                equipos.add(Equipo(team1!!, name!!, col!!))
                adapter.notifyItemChanged(equipos.size-1)
            }
            AppCompatActivity.RESULT_CANCELED ->{

                //NADA//
            }


        }

    }

}

