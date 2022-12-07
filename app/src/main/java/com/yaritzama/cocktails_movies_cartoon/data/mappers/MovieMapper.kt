package com.yaritzama.cocktails_movies_cartoon.data.mappers

import com.yaritzama.cocktails_movies_cartoon.data.models.movies.ResultMovie
import com.yaritzama.cocktails_movies_cartoon.domain.models.movies.Movies

fun ResultMovie.toDomain(): Movies{
    return Movies(
        id = this.id,
        title = this.originalTitle,
        image = this.backdropPath
    )
}