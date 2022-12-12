package com.yaritzama.cocktails_movies_cartoon.domain.repository

import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData

interface MainRepository {
    suspend fun getCharacterList(): List<MainData>
    suspend fun getMovieByRegion(region: String): MainData
    suspend fun getDrinkList(): List<MainData>
    suspend fun getDrinkByIngredient(i: String): MainData
}