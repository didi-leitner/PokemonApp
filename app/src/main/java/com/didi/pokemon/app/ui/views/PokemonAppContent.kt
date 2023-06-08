package com.didi.pokemon.app.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.didi.pokemon.app.ui.navigation.PokemonAppNavHost
import com.didi.pokemon.app.ui.navigation.pokeListRoute
import com.didi.pokemon.app.ui.theme.PokemonAppTheme


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PokemonAppContent(navController: NavHostController) {

    PokemonAppTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background,//Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {

                Column(Modifier.fillMaxSize()) {

                    PokemonAppNavHost(navController = navController, startDestination = pokeListRoute, modifier = Modifier )

                }

            }
        }
    }
}