package com.example.pokemontest.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ModelResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: T
)