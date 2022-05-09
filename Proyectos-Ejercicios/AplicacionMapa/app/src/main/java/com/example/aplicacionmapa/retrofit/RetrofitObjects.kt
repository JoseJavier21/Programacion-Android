package com.example.aplicacionmapa.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObjects {

//    var retrofitServices: RetrofitServices? = null
//
//
//    fun getRetrofit(): RetrofitServices {
//
//        if (retrofitServices == null) {
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://qastusoft.com.es/test/estech/android/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okhttpClient())
//                .build()
//
//            retrofitServices = retrofit.create(RetrofitServices::class.java)
//        }
//
//        return retrofitServices!!
//    }

    private fun okhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}