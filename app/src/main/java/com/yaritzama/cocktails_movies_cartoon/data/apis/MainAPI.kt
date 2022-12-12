package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.MainResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainAPI {

    @GET("character")
    suspend fun getCharacterList(): Response<MainResponse>

    @GET("now_playing/{api_key}&{region}")
    suspend fun getMovieByRegion(@Query("region") region: String): Response<ResultResponse>

    @GET("list.php/{i}")
    suspend fun getDrink(@Query("i") i: String): Response<ResultResponse>

    @GET("filter.php/{i}")
    suspend fun getDrinkByIngredient(@Query("i") ingredient: String): Response<ResultResponse>
}