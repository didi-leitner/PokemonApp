package com.didi.pokemon.app.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AbilityNO (val effect_entries: List<EffectEntry>)

@Serializable
data class EffectEntry(val effect: String, val language:Language )

@Serializable
data class Language(val name:String, val url: String)