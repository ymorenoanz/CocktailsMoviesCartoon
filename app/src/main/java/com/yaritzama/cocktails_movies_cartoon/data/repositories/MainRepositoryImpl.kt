package com.yaritzama.cocktails_movies_cartoon.data.repositories

import com.yaritzama.cocktails_movies_cartoon.BuildConfig
import com.yaritzama.cocktails_movies_cartoon.data.apis.CartoonAPI
import com.yaritzama.cocktails_movies_cartoon.data.apis.CocktailAPI
import com.yaritzama.cocktails_movies_cartoon.data.apis.MovieAPI
import com.yaritzama.cocktails_movies_cartoon.data.mappers.toDomain
import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiMovie: MovieAPI,
    private val apiCartoon: CartoonAPI,
    private val apiCocktail: CocktailAPI
) : MainRepository {

    override suspend fun getCharacterList(): List<MainData> {
        val responseCartoon = apiCartoon.getCharacterList()

        return responseCartoon.body()?.results?.map {
                it?.toDomain() ?: MainData()
            } ?: emptyList()
    }

    override suspend fun getMovieByRegion(region: String): List<MainData> {
        val responseMovie = apiMovie.getMovieByRegion(BuildConfig.API_KEY_MOVIES, region)
        return responseMovie.body()?.results?.map {
            it?.toDomain() ?: MainData()
        } ?: emptyList()
    }


   override suspend fun getDrinkList(): List<MainData> {
        val response = apiCocktail.getDrinkList("list")
        return response.body()?.results?.map {
            it?.toDomain() ?: MainData()
        } ?: emptyList()
    }

    override suspend fun getDrinkByIngredient(i: String): MainData {
        val response = apiCocktail.getDrinkByIngredient(i)
        return response.body()?.toDomain() ?: throw Exception("Network error")
    }
}