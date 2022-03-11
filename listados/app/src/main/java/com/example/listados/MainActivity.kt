package com.example.listados

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listados.adapter.EquipoAdapter
import com.example.listados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val equipo1 = Equipo("Mclaren", "Carlos Sainz", "naranja")
        val equipo2 = Equipo("RedBull", "Verstappen", "Azul")
        val equipo3 = Equipo("Mercedes", "Hamilton", "Verde")
        val equipo4 = Equipo("Ferrari", "Leclert", "Rojo")
        val equipo5 = Equipo("Alfa-Romeo", "Hass", "Rosa")

        val equipos = mutableListOf(equipo1, equipo2, equipo3, equipo4, equipo5)


        val llamada = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = llamada
        val adapter = EquipoAdapter(equipos)
        binding.recyclerView.adapter = adapter


        binding.mas.setOnClickListener {

        }

        binding.alldel.setOnClickListener {

        }




        // CODIGO PARA CONSEGUIR INFO DE LA SEGUNDA ACTIVIDAD, HAY QUE ADAPTARLO    //

//        val intent = Intent(this, SegundaActivity::class.java)
//        funReciberesult.launch(intent)

    }

    // CODIGO PARA CONSEGUIR INFO DE LA SEGUNDA ACTIVIDAD, HAY QUE ADAPTARLO    //


//    val funReciberesult =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
//
//            if (resultado.resultCode == Activity.RESULT_OK) {
//
//                val intent = resultado.data
//
//                if (intent != null) {
//                    val datos = intent.getStringExtra("datos")
//                }
//            }
//        }
}



