package com.example.pokemontest.domain.use_case.get_pokemon

import com.example.pokemontest.common.Resource
import com.example.pokemontest.data.repository.FakePokemonRepository
import com.example.pokemontest.presentation.pokemon_detail.PokemonDetailState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPokemonUseCaseTest {

    lateinit var getPokemonUseCase: GetPokemonUseCase
    lateinit var fakePokemonRepository: FakePokemonRepository
    private var pokemonDetailState: PokemonDetailState? = null

    @Before
    fun setUp() {
        fakePokemonRepository = FakePokemonRepository()
        getPokemonUseCase = GetPokemonUseCase(fakePokemonRepository)

        val id = "2"

        runBlocking {
            fakePokemonRepository.getPokemonById(id)
            getPokemonUseCase(id).collect { result ->

                pokemonDetailState = when (result) {
                    is Resource.Success -> {
                        PokemonDetailState(pokemonDetail = result.data)
                    }
                    is Resource.Error -> {
                        PokemonDetailState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        PokemonDetailState(isLoading = true)
                    }
                }
            }
        }
    }

    @Test
    fun `Check Pokemon byId , isEqualTo 3`() = runBlocking {
        assertThat(pokemonDetailState?.pokemonDetail?.id).isEqualTo(3)
    }

    @Test
    fun `Check Pokemon height , isEqualTo 80`() = runBlocking {
        assertThat(pokemonDetailState?.pokemonDetail?.height).isEqualTo(80)
    }

    @Test
    fun `Check Pokemon weight , isNotNull`() = runBlocking {
        assertThat(pokemonDetailState?.pokemonDetail?.height).isNotNull()
    }

    @Test
    fun `Check Pokemon power type first index by name , isEqualTo grass`() = runBlocking {
        assertThat(pokemonDetailState?.pokemonDetail?.types?.first()?.type?.name).isEqualTo("grass")
    }
}