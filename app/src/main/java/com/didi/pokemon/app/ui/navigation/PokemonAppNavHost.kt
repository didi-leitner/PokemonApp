package com.didi.pokemon.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.didi.pokemon.app.ui.views.PokemonListRoute


const val pokeListRoute = "pokemon-list-route"
const val pokeDetailRoute = "pokemon-detail-route/{pokemon_id}"

@Composable
fun PokemonAppNavHost(navController: NavHostController, startDestination: String, modifier: Modifier) {


    //ACTIONS
    val onNavigateToDetail: (id:Int) -> Unit = {
        println("TESTT navigate to " + it)
        navController.navigate(
            pokeDetailRoute
                .replace(
                    oldValue = "{pokemon_id}",
                    newValue = it.toString()
                )
        )
    }


    NavHost(navController = navController, startDestination, modifier){

        composable(pokeListRoute){

            PokemonListRoute(navigateToDetail = onNavigateToDetail)

        }
        composable(pokeDetailRoute){

        }
    }


}