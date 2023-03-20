package com.example.pokemontest.presentation.pokemon_detail

import com.example.pokemontest.domain.model.PokemonDetail

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemonDetail: PokemonDetail? = null,
    val error: String = ""
)
