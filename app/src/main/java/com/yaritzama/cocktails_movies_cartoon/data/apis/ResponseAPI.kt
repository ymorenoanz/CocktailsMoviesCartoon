package com.yaritzama.cocktails_movies_cartoon.data.apis

sealed class ResponseAPI {
    object drinkAPI: ResponseAPI()
    object cartoonAPI: ResponseAPI()
    object movieAPI: ResponseAPI()
}