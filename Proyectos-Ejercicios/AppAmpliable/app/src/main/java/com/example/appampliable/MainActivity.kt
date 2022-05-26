package com.example.appampliable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appampliable.R
import com.example.appampliable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}