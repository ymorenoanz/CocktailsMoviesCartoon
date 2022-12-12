package com.yaritzama.cocktails_movies_cartoon.data.repositories

import com.yaritzama.cocktails_movies_cartoon.data.apis.MainAPI
import com.yaritzama.cocktails_movies_cartoon.data.mappers.toDomain
import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: MainAPI
) : MainRepository {

    override suspend fun getObjectList(): List<MainData> {
        val response = api.getCharacterList()
        return response.body()?.results?.map {
                it?.toDomain() ?: MainData()
            } ?: emptyList()
    }

    override suspend fun getObjectById(name: String): MainData {
        val response = api.getMovieByRegion(name)
        return response.body()?.toDomain() ?: throw Exception("Network error")
    }
}