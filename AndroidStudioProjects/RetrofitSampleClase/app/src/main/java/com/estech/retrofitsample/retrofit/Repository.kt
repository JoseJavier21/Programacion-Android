package com.estech.retrofitsample.retrofit

class Repository {

    private val retrofitServices = RetrofitHelped.getRetrofit()

    suspend fun getallpersonajes() = retrofitServices.getAllCharacter()
}