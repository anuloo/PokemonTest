package com.example.pokemontest.domain.model

data class PokemonDetail(
    val height: Int,
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>,
    val weight: Int
)