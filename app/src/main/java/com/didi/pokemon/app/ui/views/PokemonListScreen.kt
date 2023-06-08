package com.didi.pokemon.app.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.ui.viewModel.PokemonListViewModel

@Composable
fun PokemonListRoute(viewModel: PokemonListViewModel = hiltViewModel(), navigateToDetail: (Int) -> Unit) {

    val pokemons = viewModel.pokemons.collectAsStateWithLifecycle()

    PokemonListScreen(pokemons.value, navigateToDetail)
}

@Composable
fun PokemonListScreen(pokemons: List<Pokemon>, navigateToDetail: (Int) -> Unit) {

    val emailLazyListState = rememberLazyListState()

    PokemonList(pokemons = pokemons, emailLazyListState =emailLazyListState, navigateToDetail =navigateToDetail)

}


@Composable
fun PokemonList(
    pokemons: List<Pokemon>,
    //openedEmail: Product?,
    //selectedEmailIds: Set<Int>,
    //toggleEmailSelection: (Long) -> Unit,
    emailLazyListState: LazyListState,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    Box(modifier = modifier) {

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            state = emailLazyListState
        ) {
            items(items = pokemons, key = { it.id }) { pokemon ->
                PokemonListItem(
                    pokemon,
                    navigateToDetail,
                    modifier
                    /*toggleSelection = toggleEmailSelection,
                    isOpened = openedEmail?.id == email.id,
                    isSelected = selectedEmailIds.contains(email.id)*/
                )
            }
        }
    }
}


