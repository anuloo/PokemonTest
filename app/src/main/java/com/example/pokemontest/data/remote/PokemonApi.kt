package com.example.pokemontest.data.remote

import com.example.pokemontest.data.remote.dto.ModelResponse
import com.example.pokemontest.data.remote.dto.PokemonDetailDto
import com.example.pokemontest.data.remote.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("v2/pokemon/")
    suspend fun getPokemonList(): ModelResponse<List<PokemonDto>>

    @GET("v2/pokemon/{pokemanId}/")
    suspend fun getPokemonById(@Path("pokemanId") pokemanId: String): PokemonDetailDto
}