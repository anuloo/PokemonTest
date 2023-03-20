package com.example.pokemontest.presentation.pokemon_list

import com.example.pokemontest.domain.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemon: List<Pokemon> = emptyList(),
    val error: String = ""
)
