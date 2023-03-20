package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun PokemonDto.toDomain(): Pokemon = Pokemon(
    name = name,
    url = url
)