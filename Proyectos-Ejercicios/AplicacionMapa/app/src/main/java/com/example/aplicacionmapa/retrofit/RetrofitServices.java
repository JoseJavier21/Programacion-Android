package com.example.aplicacionmapa.retrofit;

import com.example.aplicacionmapa.datamaps.MapasItem;
import retrofit2.Response;
import retrofit2.http.GET;

interface RetrofitServices {

    @GET("sitios")
    suspend fun getlugares(): Response<MapasItem>

}
