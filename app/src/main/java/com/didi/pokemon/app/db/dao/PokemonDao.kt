package com.didi.pokemon.app.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("Select * FROM pokemon_table")
    fun getAll(): Flow<List<Pokemon>>

    @Query("Select * FROM pokemon_detail_table where id = :id")
    suspend fun getPokemonDetail(id: Int): PokemonDetail

    @Upsert
    suspend fun insertAll(res: List<Pokemon>)

    @Upsert
    suspend fun insertDetail(pd: PokemonDetail)


}