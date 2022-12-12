package com.yaritzama.cocktails_movies_cartoon.domain.repository

import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData

interface MainRepository {
    suspend fun getObjectList(): List<MainData>
    suspend fun getObjectById(name: String): MainData
}