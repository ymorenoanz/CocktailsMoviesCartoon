package com.yaritzama.cocktails_movies_cartoon.data.repositories

import com.yaritzama.cocktails_movies_cartoon.data.apis.CharacterAPI
import com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy.CharacterResponse
import com.yaritzama.cocktails_movies_cartoon.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterAPI): CharacterRepository {
    override suspend fun getCharacter(): CharacterResponse {
        TODO("Not yet implemented")
    }
}