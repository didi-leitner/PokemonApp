package com.didi.pokemon.app.data.repository

import com.didi.pokemon.app.db.dao.PokemonDao
import com.didi.pokemon.app.model.Pokemon
import com.didi.pokemon.app.model.PokemonDetail
import com.didi.pokemon.app.network.IPokemonApi
import com.didi.pokemon.app.network.model.AbilityNO
import com.didi.pokemon.app.network.model.PokemonDetailNO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class PokemonRepository @Inject constructor(val api: IPokemonApi, val dao: PokemonDao): IPokemonRepository {
    override fun getAllPokemonsFromDb(): Flow<List<Pokemon>> {
        return dao.getAll()
    }


    override suspend fun getPokemonDetailFromDb(id: Int): PokemonDetail {
        return dao.getPokemonDetail(id)
    }

    override suspend fun refreshFromApi(): List<Pokemon> {
        println("TAGGG REFRESH FROM API")
        var res = emptyList<Pokemon>()
        api.getAll().apply {
            println("TAGGG REFRESH RESULT")
             res = results.map {

                val idx = it.url?.substring(0, it.url.length-1)?.lastIndexOf("/")
                val id = if(idx!= null && idx != -1) {
                    it.url.substring(0,it.url.length - 1)?.substring(idx+1)?.toInt()
                } else null

                Pokemon(id ?: Random.nextInt(),it.name,it.url)

            }
            dao.insertAll(res)

        }

        return res
    }

    override suspend fun getDetailFromApi(id: Int): PokemonDetailNO {
        return api.getPokemonDetail(id)
    }

    override suspend fun getAbilityFromApi(id: Int): AbilityNO {
        return api.getAbility(id)
    }

    override suspend fun insertDetail(detail: PokemonDetail) {
        dao.insertDetail(detail)
    }


}