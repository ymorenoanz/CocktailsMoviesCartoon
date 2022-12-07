package com.yaritzama.cocktails_movies_cartoon.data.models.cocktails


import com.google.gson.annotations.SerializedName

data class IngredientsResponse(
    @SerializedName("drinks")
    val drinks: List<Drink?>?
)