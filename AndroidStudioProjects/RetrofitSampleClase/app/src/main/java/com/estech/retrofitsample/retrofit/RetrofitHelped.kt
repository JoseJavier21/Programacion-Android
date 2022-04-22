package com.estech.retrofitsample.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelped {

    var retrofitService : RetrofitServices ? = null


    fun getRetrofit (): RetrofitServices {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl( "https://rickandmortyapi.com/api/" )
                .addConverterFactory( GsonConverterFactory .create())
                .build()
            retrofitService = retrofit.create(RetrofitServices ::class.java)
        }
        return retrofitService !!
    }
}