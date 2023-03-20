package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.Other
import com.google.gson.annotations.SerializedName

data class OtherDto(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorldDto
)

fun OtherDto.toDomain(): Other = Other(
    dreamWorld = dreamWorld.toDomain()
)