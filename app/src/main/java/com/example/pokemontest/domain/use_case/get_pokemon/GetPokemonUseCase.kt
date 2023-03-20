package com.example.pokemontest.domain.use_case.get_pokemon

import com.example.pokemontest.common.Resource
import com.example.pokemontest.domain.model.PokemonDetail
import com.example.pokemontest.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(pokemanId: String): Flow<Resource<PokemonDetail>> = flow {
        try {
            emit(Resource.Loading<PokemonDetail>())
            val pokeman = repository.getPokemonById(pokemanId)
            emit(Resource.Success<PokemonDetail>(pokeman))
        } catch (e: HttpException) {
            emit(
                Resource.Error<PokemonDetail>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<PokemonDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}