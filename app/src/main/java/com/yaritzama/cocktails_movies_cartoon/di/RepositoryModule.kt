package com.yaritzama.cocktails_movies_cartoon.di

import com.yaritzama.cocktails_movies_cartoon.data.repositories.MainRepositoryImpl
import com.yaritzama.cocktails_movies_cartoon.domain.repository.MainRepository
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
    abstract fun providesMovieRepository(impl: MovieRepositoryImpl): MainRepository

    @Binds
    abstract fun providesCocktailRepository(impl: MainRepositoryImpl): CocktailRepository

}