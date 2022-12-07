package com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val results: List<ResultCharacter?>?
)