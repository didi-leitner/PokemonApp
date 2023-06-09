package com.didi.pokemon.app.network

import com.didi.pokemon.app.network.model.AbilityNO
import com.didi.pokemon.app.network.model.PokemonDetailNO
import com.didi.pokemon.app.network.model.PokemonNO
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonApi {


    @GET("pokemon/")
    suspend fun getAll(): PokemonNO

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetail(@Path("pokemonId") pokemonId: Int): PokemonDetailNO

    @GET("ability/{abilityId}")
    suspend fun getAbility(@Path("abilityId") pokemonId: Int): AbilityNO

//@GET("api/unload-movements")
    //suspend fun unloadDelivery(@Query("courierId") courierId: UUID, @Query("packagingId") packagingId: UUID): Response<Void>

    //@GET("api/menu-role-ls/{roleId}")
    //suspend fun getMenuByRole(@Path("roleId") roleId: UUID, @Query("resourceTypeId") typeId: Int = 1): Response<List<MenuRoleDto>>

}