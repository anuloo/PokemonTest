package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.Sprites
import com.google.gson.annotations.SerializedName

data class SpritesDto(
    @SerializedName("other")
    val other: OtherDto,
)

fun SpritesDto.toDomain(): Sprites = Sprites(
    other = other.toDomain()
)