package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.cocktails.Drink
import com.yaritzama.cocktails_movies_cartoon.data.models.cocktails.IngredientsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailAPI {
    @GET("list.php/{i}")
    suspend fun getDrink(@Query("i") ingredient: String): Response<List<Drink>>

    @GET("filter.php/{i}")
    suspend fun getDrinkByIngredient(@Query("i") ingredient: String): Response<IngredientsResponse>
}