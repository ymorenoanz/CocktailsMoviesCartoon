package com.yaritzama.cocktails_movies_cartoon.domain.repository

import com.yaritzama.cocktails_movies_cartoon.domain.models.movies.Movies

interface MovieRepository {
    suspend fun getMovie(region: String) : List<Movies>
}