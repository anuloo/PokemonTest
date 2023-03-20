package com.example.pokemontest.data.repository

import com.example.pokemontest.domain.model.*
import com.example.pokemontest.domain.repository.PokemonRepository

class FakePokemonRepository : PokemonRepository {

    private val pokemon = PokemonDetail(
        id = 3,
        height = 80,
        weight = 900,
        name = "venusaur",
        types = listOf(
            Type(type = TypeItem(name = "grass")),
            Type(type = TypeItem(name = "poison"))
        ),
        sprites = Sprites(
            other = Other(
                dreamWorld = DreamWorld(
                    frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/3.svg"
                )
            )
        )

    )

    override suspend fun getPokemonList(): List<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>()
        ('a'..'z').forEachIndexed { index, c ->
            val id = index + 1
            pokemonList.add(
                Pokemon(
                    name = c.toString(),
                    url = "$c _$id",
                )
            )
        }
        return pokemonList
    }

    override suspend fun getPokemonById(pokemanId: String): PokemonDetail {
        return pokemon
    }
}