package com.yaritzama.cocktails_movies_cartoon.data.mappers

import com.yaritzama.cocktails_movies_cartoon.data.models.cocktails.Drink
import com.yaritzama.cocktails_movies_cartoon.domain.models.cocktails.Cocktail

fun Drink.toDomain(): Cocktail{
    return Cocktail(
        strIngredient1 = this.strIngredient1
    )
}