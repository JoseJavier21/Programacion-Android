package com.example.appgatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appgatos.DataClass.EnvioVoto
import com.example.appgatos.Retrofit.TOKEN
import com.example.appgatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Constantes.TOKEN
        TOKEN

        val envioVoto = EnvioVoto("algo", "jose", 0)
//        repositorio.getVote("jose")
    }



}