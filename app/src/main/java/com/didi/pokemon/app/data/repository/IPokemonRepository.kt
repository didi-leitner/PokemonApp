package com.didi.pokemon.app.data.repository

import com.didi.pokemon.app.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {

    fun getAll(): Flow<List<Pokemon>>
    suspend fun refreshFromApi()
}