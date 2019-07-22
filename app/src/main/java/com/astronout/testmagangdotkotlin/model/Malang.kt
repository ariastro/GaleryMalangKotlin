package com.astronout.testmagangdotkotlin.model


import com.google.gson.annotations.SerializedName

data class Malang(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)