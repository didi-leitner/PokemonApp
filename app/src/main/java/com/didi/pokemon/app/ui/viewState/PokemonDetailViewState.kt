package com.didi.pokemon.app.ui.viewState

import com.didi.pokemon.app.model.PokemonDetail

data class PokemonDetailViewState(val detail: PokemonDetail?, val list: List<Pair<String, String>>) {
}