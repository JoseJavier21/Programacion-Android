package com.example.listados

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listados.adapter.EquipoAdapter
import com.example.listados.databinding.ActivityMainBinding
import com.example.listados.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: EquipoAdapter

    private  lateinit var equipos: MutableList<Equipo>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        // Para el titulo de el menu
        supportActionBar?.setTitle("Equipos de F1")
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)"


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
            RESULT_CANCELED->{

                //NADA//
            }


        }

    }
}




