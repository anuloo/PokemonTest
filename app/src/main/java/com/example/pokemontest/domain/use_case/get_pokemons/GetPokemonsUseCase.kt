package com.example.pokemontest.domain.use_case.get_pokemons

import com.example.pokemontest.common.Resource
import com.example.pokemontest.domain.model.Pokemon
import com.example.pokemontest.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<Resource<List<Pokemon>>> = flow {
        try {
            emit(Resource.Loading<List<Pokemon>>())
            val list = repository.getPokemonList()
            list.forEach {
                val string = it.url
                val result = string.substringAfterLast("pokemon/").removeSuffix("/")
               // println("test result: $result")
            }
            emit(Resource.Success<List<Pokemon>>(list))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Pokemon>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Pokemon>>("Couldn't reach server. Check your internet connection."))
        }
    }
}