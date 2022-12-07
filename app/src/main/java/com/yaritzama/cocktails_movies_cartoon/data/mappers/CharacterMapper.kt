package com.yaritzama.cocktails_movies_cartoon.data.mappers

import com.yaritzama.cocktails_movies_cartoon.data.models.rickandmorthy.ResultCharacter
import com.yaritzama.cocktails_movies_cartoon.domain.models.rickandmorthy.CharacterRickMorty

fun ResultCharacter.toDomain(): CharacterRickMorty{
    return CharacterRickMorty(
        id = this.id,
        name = this.name,
        image = this.image,
        species = this.species
    )
}