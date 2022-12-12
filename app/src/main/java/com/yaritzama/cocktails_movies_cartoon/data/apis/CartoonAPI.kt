package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.MainResponse
import retrofit2.Response
import retrofit2.http.GET

interface CartoonAPI {
    @GET("character")
    suspend fun getCharacterList(): Response<MainResponse>
}