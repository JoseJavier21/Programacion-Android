package com.estech.retrofitsample.retrofit

import com.estech.retrofitsample.modelos.Respuesta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitServices {

    // ES PARA PONER AQUI TODAS LAS FUNCIONES DE LOS ENDPOINTS DE LAS API


    @GET("character")
    suspend fun getallpersonajes(): Response<Respuesta>

    @POST("batch/{id}/add-item")

}