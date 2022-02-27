package com.example.powerofyou.data.network

import com.example.powerofyou.data.model.AmorResponseItem
import com.example.powerofyou.data.model.ArmorResponse
import retrofit2.Call
import retrofit2.http.GET

interface ArmorApi {

    @GET("armor")
    suspend fun getArmor(): ArrayList<AmorResponseItem>
}