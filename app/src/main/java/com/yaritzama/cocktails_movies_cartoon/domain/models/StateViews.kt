package com.yaritzama.cocktails_movies_cartoon.domain.models

sealed class StateViews{
    object viewMovie: StateViews()
    object viewCartoon: StateViews()
    object viewCocktails: StateViews()
}