package com.yaritzama.cocktails_movies_cartoon.di

import com.yaritzama.cocktails_movies_cartoon.data.apis.CharacterAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterModule{

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun characterAPIProvider(retrofit: Retrofit): CharacterAPI = retrofit.create()
}