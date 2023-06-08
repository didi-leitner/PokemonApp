package com.didi.pokemon.app.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.ui.designsystem.MyListItemWImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonListItem(
    pokemon: Pokemon,
    navigateToDetail: (Int) -> Unit,
    //toggleSelection: (Int) -> Unit,
    modifier: Modifier = Modifier,
    //isOpened: Boolean = false,
    //isSelected: Boolean = false,
) {


    MyListItemWImage(modifier = modifier, id = pokemon.id,
        title = pokemon.name,
        imagePath = pokemon.imageUrl,
        navigateToDetail = navigateToDetail)
}