package com.yaritzama.cocktails_movies_cartoon.di

import com.yaritzama.cocktails_movies_cartoon.BuildConfig
import com.yaritzama.cocktails_movies_cartoon.data.apis.CartoonAPI
import com.yaritzama.cocktails_movies_cartoon.data.apis.CocktailAPI
import com.yaritzama.cocktails_movies_cartoon.data.apis.MovieAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    @Singleton
    fun providesOkHttpClient() = OkHttpClient.Builder()
        .writeTimeout(10L, TimeUnit.SECONDS )
        .readTimeout(10L, TimeUnit.SECONDS).addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()

    @Provides
    @Singleton
    @Named("RickMortyAPI")
    fun providesRetrofitCharacter() = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL_CARTOON)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("MovieAPI")
    fun providesRetrofitMovie() = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL_MOVIES)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    @Named("CocktailAPI")
    fun providesRetrofitCocktail() = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun cartoonAPIProvider(@Named("RickMortyAPI")retrofit: Retrofit): CartoonAPI {
        return retrofit.create(CartoonAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieAPI(@Named("MovieAPI")retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)

    @Provides
    @Singleton
    fun providesCocktailAPI(@Named("CocktailAPI")retrofit: Retrofit): CocktailAPI = retrofit.create(CocktailAPI::class.java)
}