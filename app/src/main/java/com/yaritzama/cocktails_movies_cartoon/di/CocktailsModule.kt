package com.yaritzama.cocktails_movies_cartoon.di

import com.yaritzama.cocktails_movies_cartoon.data.apis.CocktailAPI
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
object CocktailsModule {

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun cocktailAPIProvider(retrofit: Retrofit): CocktailAPI = retrofit.create()
}