package com.example.appgatos.Retrofit

import android.media.session.MediaSession
import com.example.appgatos.DataClass.EnvioVoto
import com.example.appgatos.DataClass.Gato
import com.example.appgatos.DataClass.RespuestaVoto
import com.example.appgatos.DataClass.Voto
import retrofit2.Response
import retrofit2.http.*

const val TOKEN = "f9ef66c8-bc28-416f-8d78-0562abc906ea"

interface CatServices {

    @Headers("x-api-key:$TOKEN")
    @GET("breeds")
    suspend fun getCatList(): Response<List<Gato>>

    @Headers("x-api-key:$TOKEN")
    @GET("votes")
    suspend fun getVote(@Query ("sub_id")nombre : String): Response<List<Voto>>

    @Headers("x-api-key:$TOKEN")
    @POST("votes")
    suspend fun enviarVoto(@Body envioVoto: EnvioVoto) : Response<RespuestaVoto>
}