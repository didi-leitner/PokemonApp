package com.didi.pokemon.app.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.didi.pokemon.app.data.repository.IPokemonRepository
import com.didi.pokemon.app.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(repoPokemon: IPokemonRepository): ViewModel() {

    /*private val _viewState = MutableStateFlow(PokeListViewState(emptyList()))
    val viewState: StateFlow<PokeListViewState>
        get() = _viewState*/

    init {
        viewModelScope.launch {
            repoPokemon.refreshFromApi()
        }
    }


    //DB, unique source of truth
    val pokemons: StateFlow<List<Pokemon>>  = repoPokemon.getAll()
        .stateIn(scope = viewModelScope,
            started = WhileSubscribed(5_000),
            initialValue = emptyList(),
        )

}