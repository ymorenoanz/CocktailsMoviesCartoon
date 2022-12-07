package com.yaritzama.cocktails_movies_cartoon.data.repositories

import com.yaritzama.cocktails_movies_cartoon.data.apis.MovieAPI
import com.yaritzama.cocktails_movies_cartoon.domain.models.movies.Movies
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieAPI): MovieRepository {
    override suspend fun getMovie(region: String): List<Movies> {
        TODO("Not yet implemented")
    }
}