package com.estech.retrofitsample.retrofit

import android.content.ClipData.Item
import com.estech.retrofitsample.modelos.Respuesta
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


/**
 * Created by sergi on 19/04/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

interface RetrofitService {

    @GET("character")
    suspend fun dameTodosPersonajes(): Response<Respuesta>

    @POST("batch/{id}/add-item")
    suspend fun addItem(@Path("id") id: Int, @Body item: Item?): Response<Respuesta>
}