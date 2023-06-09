package com.didi.pokemon.app.data.di

import com.didi.pokemon.app.data.repository.IPokemonRepository
import com.didi.pokemon.app.data.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindPokeRepository(repository: PokemonRepository): IPokemonRepository
}