package com.example.pokemontest.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemontest.common.Resource
import com.example.pokemontest.domain.use_case.get_pokemons.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemanUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PokemonListState())
    val state: State<PokemonListState> = _state

    init {
        getPokeman()
    }

    private fun getPokeman() {
        getPokemanUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonListState(pokemon = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PokemonListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PokemonListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}