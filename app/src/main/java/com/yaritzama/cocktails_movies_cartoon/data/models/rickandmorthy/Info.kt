package com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)