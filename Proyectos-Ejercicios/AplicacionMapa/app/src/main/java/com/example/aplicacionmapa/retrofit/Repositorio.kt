package com.example.aplicacionmapa.retrofit

class Repositorio {

    private val retrofit = RetrofitObjects.getRetrofit()

    suspend fun getlugares = retrofit.getlugares()


}