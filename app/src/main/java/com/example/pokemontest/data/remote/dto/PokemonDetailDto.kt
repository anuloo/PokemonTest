package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.PokemonDetail
import com.google.gson.annotations.SerializedName

data class PokemonDetailDto(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("sprites")
    val sprites: SpritesDto,
    @SerializedName("types")
    val types: List<TypeDto>,
    @SerializedName("weight")
    val weight: Int
)

fun PokemonDetailDto.toDomain(): PokemonDetail = PokemonDetail(
    height = height,
    weight = weight,
    id = id,
    name = name,
    sprites = sprites.toDomain(),
    types = types.map {
        it.toDomain()
    }
)