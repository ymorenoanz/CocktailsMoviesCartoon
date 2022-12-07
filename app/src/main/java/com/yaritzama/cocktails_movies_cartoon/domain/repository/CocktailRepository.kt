package com.yaritzama.cocktails_movies_cartoon.domain.repository

import com.yaritzama.cocktails_movies_cartoon.domain.models.cocktails.Cocktail

interface CocktailRepository {

    suspend fun getIngredients(): List<Cocktail>
    suspend fun getCocktailByIngredient(ingredient: String)
}