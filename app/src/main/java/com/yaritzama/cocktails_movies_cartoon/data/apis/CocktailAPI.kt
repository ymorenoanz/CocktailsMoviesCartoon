package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.DrinksResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.MainDrink
import com.yaritzama.cocktails_movies_cartoon.data.models.MainResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import retrofit2.Response
import retrofit2.http.*

interface CocktailAPI {

    @GET("list.php")
    suspend fun getDrinkList(@Query("api-key") apikey: Int,
                             @Query("i") i: String): Response<MainResponse>
    @GET("filter.php")
    suspend fun getDrinkByIngredient(@Query("api-key") apikey: Int,
        @Query("i") ingredient: String): Response<MainDrink>
}