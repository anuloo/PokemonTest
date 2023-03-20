package com.example.pokemontest.domain.repository

import com.example.pokemontest.domain.model.Pokemon
import com.example.pokemontest.domain.model.PokemonDetail

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemonById(pokemanId: String): PokemonDetail
}