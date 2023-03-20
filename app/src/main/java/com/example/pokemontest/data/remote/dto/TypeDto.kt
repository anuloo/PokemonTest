package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.Type
import com.google.gson.annotations.SerializedName

data class TypeDto(
    @SerializedName("type")
    val type: TypeItemDto
)

fun TypeDto.toDomain(): Type = Type(
    type = type.toDomain()
)