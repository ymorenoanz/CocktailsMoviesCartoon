package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.MainResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailAPI {
    @GET("list.php")
    suspend fun getDrinkList(@Query("i") i: String): Response<MainResponse>

    @GET("filter.php")
    suspend fun getDrinkByIngredient(@Query("i") ingredient: String): Response<ResultResponse>
}