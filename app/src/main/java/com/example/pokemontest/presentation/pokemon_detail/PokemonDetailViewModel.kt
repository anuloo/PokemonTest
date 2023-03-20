package com.example.pokemontest.presentation.pokemon_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemontest.common.Constants
import com.example.pokemontest.common.Resource
import com.example.pokemontest.domain.use_case.get_pokemon.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetPokemonUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PokemonDetailState())
    val state: State<PokemonDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_POKEMON_ID)?.let { id ->
            getPokemonById(id)
        }
    }

    private fun getPokemonById(id: String) {
        getCoinUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonDetailState(pokemonDetail = result.data)
                }
                is Resource.Error -> {
                    _state.value = PokemonDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PokemonDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}