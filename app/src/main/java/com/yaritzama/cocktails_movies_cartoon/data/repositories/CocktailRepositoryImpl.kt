package com.yaritzama.cocktails_movies_cartoon.data.repositories

import com.yaritzama.cocktails_movies_cartoon.data.apis.CocktailAPI
import com.yaritzama.cocktails_movies_cartoon.domain.models.cocktails.Cocktail
import com.yaritzama.cocktails_movies_cartoon.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val api: CocktailAPI) : CocktailRepository {
    override suspend fun getIngredients(): List<Cocktail> {
        TODO("Not yet implemented")
    }

    override suspend fun getCocktailByIngredient(ingredient: String) {
        TODO("Not yet implemented")
    }
}