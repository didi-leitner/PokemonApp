package com.didi.pokemon.app.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.didi.pokemon.app.data.repository.IPokemonRepository
import com.didi.pokemon.app.model.PokemonDetail
import com.didi.pokemon.app.ui.viewState.PokemonDetailViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repo: IPokemonRepository
) : ViewModel() {

    private val id: Int? = savedStateHandle["pokemon_id"]
    private val _viewState = MutableStateFlow(PokemonDetailViewState(null, emptyList()))
    val viewState: StateFlow<PokemonDetailViewState>
        get() = _viewState

    init {
        viewModelScope.launch {
            try {
                id?.let {

                    _viewState.value = _viewState.value
                        .copy(detail = repo.getPokemonDetailFromDb(id), emptyList())


                    val res = repo.getDetailFromApi(id)
                    // res.abilities
                    val detail = PokemonDetail(id, res.name, res.sprites.front_shiny)
                    _viewState.value = _viewState.value.copy(detail = detail)


                    repo.insertDetail(detail)


                    val list = mutableListOf<Pair<String, String>>()
                    //this.sprites
                    for (ab in res.abilities) {
                        val name = ab.ability.name
                        //val desc
                        val url = ab.ability.url.substring(0, ab.ability.url.length-1)
                        val idx = url.lastIndexOf("/")
                        val str = url.substring(idx + 1).toInt()
                        val ab = repo.getAbilityFromApi(str)
                        val effectEntry = ab.effect_entries.find {
                            it.language.name == "en"
                        }
                        val desc = effectEntry?.effect ?: ""
                        list.add(Pair(name, desc))
                    }

                    _viewState.value = _viewState.value.copy(list = list)
                    //request abilities, and update a viewState
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    //if DB unique source of truth
    /*val pokemonDetail: StateFlow<PokemonDetail?> = repo.getPokemonDetailFromDb(id!!)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null,
        )*/
}