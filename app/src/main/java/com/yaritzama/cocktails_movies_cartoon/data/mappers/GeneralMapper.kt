package com.yaritzama.cocktails_movies_cartoon.data.mappers

import com.yaritzama.cocktails_movies_cartoon.data.models.ResultResponse
import com.yaritzama.cocktails_movies_cartoon.domain.models.MainData

fun ResultResponse.toDomain(): MainData{
    return MainData(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl
    )
}