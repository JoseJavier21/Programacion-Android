package com.example.weatherapp.retrofit

import com.example.weatherapp.modelo.Tiempo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("Forecast")
    suspend fun getweather(
        @Query("days") days: Int,
        @Query("location") location: String,
        @Query("Authoritazion") token: String
    ): Response<Tiempo>
}