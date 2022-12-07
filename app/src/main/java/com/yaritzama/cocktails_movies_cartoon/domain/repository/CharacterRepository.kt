package com.yaritzama.cocktails_movies_cartoon.domain.repository

import com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy.CharacterResponse

interface CharacterRepository {

    suspend fun getCharacter(): CharacterResponse
}