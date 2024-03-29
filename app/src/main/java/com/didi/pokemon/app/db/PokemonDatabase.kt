package com.didi.pokemon.app.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.didi.pokemon.app.db.dao.PokemonDao
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.model.PokemonDetail


@Database(entities = [Pokemon::class, PokemonDetail::class], version = 2, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonsDao(): PokemonDao


    companion object {

        @Volatile
        private var instance: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PokemonDatabase {
            return Room.databaseBuilder(context, PokemonDatabase::class.java, "pokemon_database")
                .fallbackToDestructiveMigration()//TODO
                .build()
        }
    }
}

