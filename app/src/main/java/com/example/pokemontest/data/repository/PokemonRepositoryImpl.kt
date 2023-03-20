package com.example.pokemontest.data.repository

import com.example.pokemontest.data.remote.PokemonApi
import com.example.pokemontest.data.remote.dto.toDomain
import com.example.pokemontest.domain.model.Pokemon
import com.example.pokemontest.domain.model.PokemonDetail
import com.example.pokemontest.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemonList(): List<Pokemon> {
        return api.getPokemonList().results.map {
            it.toDomain()
        }
    }

    override suspend fun getPokemonById(pokemanId: String): PokemonDetail {
        return api.getPokemonById(pokemanId).toDomain()
    }
}