package com.example.pokemontest.presentation.pokemon_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokemontest.R
import com.example.pokemontest.presentation.component.DetailRow
import com.example.pokemontest.presentation.component.HeaderBar
import com.example.pokemontest.presentation.component.TitleBar
import com.example.pokemontest.presentation.component.TypeRow
import com.example.pokemontest.presentation.pokemon_detail.components.VectorImage

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        state.pokemonDetail?.name?.let {
            HeaderBar(
                modifier = Modifier.align(Alignment.TopCenter),
                title = it,
                onBackClick = onBackClick
            )
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            state.pokemonDetail?.let { pokemon ->

                TitleBar(
                    text = pokemon.name.uppercase(),
                    modifier = Modifier.fillMaxWidth()
                )

                VectorImage(
                    modifier = Modifier,
                    url = pokemon.sprites.other.dreamWorld.frontDefault
                )

                DetailRow(
                    title = stringResource(id = R.string.pokemon_weight),
                    value = pokemon.weight.toString()
                )
                DetailRow(title = "Height", value = pokemon.height.toString())
                TypeRow(title = "Types:", types = pokemon.types)
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}