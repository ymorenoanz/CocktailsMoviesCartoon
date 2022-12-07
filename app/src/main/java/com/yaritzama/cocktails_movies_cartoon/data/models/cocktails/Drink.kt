package com.yaritzama.cocktails_movies_cartoon.data.models.cocktails


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("strIngredient1")
    val strIngredient1: String?
)