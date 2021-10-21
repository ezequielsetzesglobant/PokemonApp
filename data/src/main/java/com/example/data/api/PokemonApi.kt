package com.example.data.api

import com.example.data.response.TypeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface PokemonApi {

    @GET("types")
    fun getResponseTypes(@Header("Authorization") authorization: String): Call<TypeResponse>
}
