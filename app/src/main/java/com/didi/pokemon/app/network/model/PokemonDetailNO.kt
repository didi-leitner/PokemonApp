package com.didi.pokemon.app.network.model

import kotlinx.serialization.Serializable


@Serializable
data class PokemonDetailNO (val abilities: List<Ability>, val name:String, val sprites: Sprites)



@Serializable
data class Ability(val ability: AbilityNameAndUrl, val is_hidden: Boolean, val slot: Int)

@Serializable
data class AbilityNameAndUrl(val name: String, val url: String)

@Serializable
data class Sprites(val front_default: String, val front_shiny: String)