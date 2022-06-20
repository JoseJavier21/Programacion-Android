package com.example.weatherapp.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helper {

    val url = "https://api.m3o.com/v1/weather/"


    var retrofitService: Service? = null

    fun getRetrofit(): Service {

        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient())
                .build()

            retrofitService = retrofit.create(Service::class.java)
        }

        return retrofitService!!
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    private fun okhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.d("MI ETIQUETA", it)
        }
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return client
    }
}
