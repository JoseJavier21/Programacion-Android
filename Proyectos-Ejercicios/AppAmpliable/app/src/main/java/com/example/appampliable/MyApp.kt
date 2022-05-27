package com.example.appampliable

import android.app.Application
import com.example.appampliable.Room.CircuitDataBase
import com.example.appampliable.Room.Repositorio

class MyApp: Application() {
    val database by lazy { CircuitDataBase.getDatabase(this)}
    val repositorio by lazy { Repositorio(database.CircuitInterface())}
}