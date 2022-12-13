package com.yaritzama.cocktails_movies_cartoon.domain.models

data class MainData(
    val id: Int? = 0,
    val name: String? = "",
    val title: String? = "",
    val poster_path: String? = "",
    val strDrink: String? = "",
    val strDrinkThumb: String? = ""
)
