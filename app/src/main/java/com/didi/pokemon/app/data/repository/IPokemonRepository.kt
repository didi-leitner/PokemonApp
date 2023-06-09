package com.didi.pokemon.app.data.repository

import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.model.PokemonDetail
import com.didi.pokemon.app.network.model.AbilityNO
import com.didi.pokemon.app.network.model.PokemonDetailNO
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {

    fun getAllPokemonsFromDb(): Flow<List<Pokemon>>

    suspend fun getPokemonDetailFromDb(id: Int): PokemonDetail
    suspend fun refreshFromApi(): List<Pokemon>

    suspend fun getDetailFromApi(id: Int): PokemonDetailNO

    suspend fun getAbilityFromApi(id: Int): AbilityNO

    suspend fun insertDetail(detail: PokemonDetail)
}