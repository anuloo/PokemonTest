package com.example.pokemontest.domain.use_case.get_pokemons

import com.example.pokemontest.common.Resource
import com.example.pokemontest.data.repository.FakePokemonRepository
import com.example.pokemontest.presentation.pokemon_list.PokemonListState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPokemonsUseCaseTest {

    lateinit var getPokemonsUseCase: GetPokemonsUseCase
    private lateinit var fakePokemonRepository: FakePokemonRepository
    private var pokemonListState: PokemonListState? = null

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        fakePokemonRepository = FakePokemonRepository()
        getPokemonsUseCase = GetPokemonsUseCase(fakePokemonRepository)


        runTest {
            fakePokemonRepository.getPokemonList()
            getPokemonsUseCase().collect { result ->
                pokemonListState = when (result) {
                    is Resource.Success -> {
                        PokemonListState(pokemon = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        PokemonListState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        PokemonListState(isLoading = true)
                    }
                }
            }

        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check Pokemons list , isNotEmpty`() = runTest {
        assertThat(pokemonListState?.pokemon?.size).isGreaterThan(0)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check Pokemon third index by name , equalTo a`() = runTest() {
        assertThat(pokemonListState?.pokemon?.first()?.name).isEqualTo("a")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Check Pokemons list is loading , false`() = runTest() {
        assertThat(pokemonListState?.isLoading).isEqualTo(false)
    }
}