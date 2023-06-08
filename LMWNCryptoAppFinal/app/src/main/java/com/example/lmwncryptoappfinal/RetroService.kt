package com.example.lmwncryptoappfinal

import com.example.lmwncryptoappfinal.models.coinsData
import retrofit2.http.GET

interface RetroService {

    @GET("/v2/coins")
    suspend fun getDataFromApi() : coinsData
}