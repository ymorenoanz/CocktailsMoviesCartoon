package com.yaritzama.cocktails_movies_cartoon.data.mappers

import com.yaritzama.cocktails_movies_cartoon.data.models.DrinksResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData

fun ResultResponse.toDomain(): MainData{
    return MainData(
        id = this.id,
        name = this.name,
        title = this.title,
        poster_path = this.poster_path
    )
}

fun DrinksResponse.toDomain(): MainData{
    return MainData(
        idDrink = this.idDrinks,
        strDrink = this.strDrink,
        strDrinkThumb = this.strDrinkThumb
    )
}