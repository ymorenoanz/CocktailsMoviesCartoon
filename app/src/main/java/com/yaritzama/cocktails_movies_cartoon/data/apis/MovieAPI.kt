package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.BuildConfig
import com.yaritzama.cocktails_movies_cartoon.data.models.MainResponse
import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("now_playing")
    suspend fun getMovieByRegion(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY_MOVIES,
        @Query("region") region: String): Response<ResultResponse>
}