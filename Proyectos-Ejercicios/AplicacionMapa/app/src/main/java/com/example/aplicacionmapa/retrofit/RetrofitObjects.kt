package com.example.aplicacionmapa.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObjects {

    var retrofitServices: RetrofitServices? = null


    fun getRetrofit(): RetrofitServices {

        if (retrofitServices == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://qastusoft.com.es/test/estech/android/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofitServices = retrofit.create(RetrofitServices::class.java)
        }

        return retrofitServices!!
    }

}