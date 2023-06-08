package com.didi.pokemon.app.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.didi.pokemon.app.model.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("Select * FROM pokemon_table")
    fun getAll(): Flow<List<Pokemon>>

    @Upsert
    suspend fun insertAll(res: List<Pokemon>)


}