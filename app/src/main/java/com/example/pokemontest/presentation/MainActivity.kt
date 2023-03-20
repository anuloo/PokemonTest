package com.example.pokemontest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemontest.presentation.pokemon_detail.PokemonDetailScreen
import com.example.pokemontest.presentation.pokemon_list.PokemonListScreen
import com.example.pokemontest.presentation.ui.theme.PokemonTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PokemonListScreen.route
                    ) {
                        composable(
                            route = Screen.PokemonListScreen.route
                        ) {
                            PokemonListScreen(
                                onItemClick = {
                                    navController.navigate(Screen.PokemonDetailScreen.route + "/${it+1}")
                                }
                            )
                        }
                        composable(
                            route = Screen.PokemonDetailScreen.route + "/{pokemonId}"
                        ) {
                            PokemonDetailScreen(
                                onBackClick = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokemonTestTheme {
        Greeting("Android")
    }
}