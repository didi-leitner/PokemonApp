package com.didi.pokemon.app.data.repository

import com.didi.pokemon.app.db.dao.PokemonDao
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.network.IPokemonApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class PokemonRepository @Inject constructor(val api: IPokemonApi, val dao: PokemonDao): IPokemonRepository {
    override fun getAll(): Flow<List<Pokemon>> {
        return dao.getAll()
    }

    override suspend fun refreshFromApi() {
        println("TAGGG REFRESH FROM API")
        api.getAll().apply {
            println("TAGGG REFRESH RESULT")
            val res = results.map {

                val idx = it.url?.substring(0, it.url.length-1)?.lastIndexOf("/")
                val id = if(idx!= null && idx != -1) {
                    it.url.substring(0,it.url.length - 1)?.substring(idx+1)?.toInt()
                } else null

                Pokemon(id ?: Random.nextInt(),it.name,it.url)

            }
            dao.insertAll(res)

        }
    }


}