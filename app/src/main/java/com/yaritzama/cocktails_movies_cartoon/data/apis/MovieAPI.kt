package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.movies.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("now_playing/{api_key}&{region}")
    suspend fun getMovieByRegion(@Query("region") region: String): Response<MoviesResponse>
}