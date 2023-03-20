package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.DreamWorld
import com.google.gson.annotations.SerializedName

data class DreamWorldDto(
    @SerializedName("front_default")
    val frontDefault: String,
)

fun DreamWorldDto.toDomain(): DreamWorld = DreamWorld(
    frontDefault = frontDefault
)