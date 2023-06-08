package com.didi.pokemon.app.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonNO (
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResultNO>,
)


@Serializable
data class PokemonResultNO (val name: String, val url: String?)