package com.yaritzama.cocktails_movies_cartoon.di

import com.yaritzama.cocktails_movies_cartoon.data.repositories.CharacterRepositoryImpl
import com.yaritzama.cocktails_movies_cartoon.data.repositories.CocktailRepositoryImpl
import com.yaritzama.cocktails_movies_cartoon.data.repositories.MovieRepositoryImpl
import com.yaritzama.cocktails_movies_cartoon.domain.repository.CharacterRepository
import com.yaritzama.cocktails_movies_cartoon.domain.repository.CocktailRepository
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    abstract fun providesMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun providesCocktailRepository(impl: CocktailRepositoryImpl): CocktailRepository

}