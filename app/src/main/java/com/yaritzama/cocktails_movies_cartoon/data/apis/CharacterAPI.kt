package com.yaritzama.cocktails_movies_cartoon.data.apis

import com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterAPI {
    @GET("character")
    suspend fun getCharacterList(): Response<CharacterResponse>
}