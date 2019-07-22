package com.astronout.testmagangdotkotlin.api

import com.astronout.testmagangdotkotlin.model.Malang
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("/Gallery_Malang_Batu.json")
    fun fetchAllItem(): Call<List<Malang>>
}