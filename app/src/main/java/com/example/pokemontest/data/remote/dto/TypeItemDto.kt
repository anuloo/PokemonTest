package com.example.pokemontest.data.remote.dto

import com.example.pokemontest.domain.model.TypeItem
import com.google.gson.annotations.SerializedName

data class TypeItemDto(
    @SerializedName("name")
    val name: String,
)

fun TypeItemDto.toDomain(): TypeItem = TypeItem(
    name = name,
)