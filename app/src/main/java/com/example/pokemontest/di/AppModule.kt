package com.example.pokemontest.di

import com.example.pokemontest.BuildConfig
import com.example.pokemontest.common.Constants
import com.example.pokemontest.data.remote.PokemonApi
import com.example.pokemontest.data.repository.PokemonRepositoryImpl
import com.example.pokemontest.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(
    ): HttpLoggingInterceptor {
        val level = when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }

        return HttpLoggingInterceptor().apply {
            this.level = level
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(
        client: OkHttpClient
    ): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }
}