package com.example.listados

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listados.databinding.ActivitySecondBinding
import com.example.listados.databinding.ContenedorBinding

class SegundaActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Terminar, cambiar variables para que sean las mias y que se pueda usar  //

        binding.anadir.setOnClickListener {

            val intent = Intent()
            intent.putExtra("equipo", binding.equipo.toString().toInt())
            intent.putExtra("nombre", binding.nombre.text.toString())
            intent.putExtra("color",  binding.color.text.toString())
            setResult( 3,intent)
            finish()

        }






    }

}

