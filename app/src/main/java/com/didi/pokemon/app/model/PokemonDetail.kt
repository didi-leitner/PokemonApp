package com.didi.pokemon.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_detail_table")
data class PokemonDetail (@PrimaryKey val id: Int,
                          //stats
                          //abilities?
                          val name: String,
                          val pictureUrl: String?)