package com.didi.pokemon.app.di


import android.content.Context
import com.didi.pokemon.app.db.PokemonDatabase
import com.didi.pokemon.app.db.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    /*@Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao) : ProductsLocalDataSource {
        return ProductsLocalDataSourceImpl(productsDao)
    }*/

    @Singleton
    @Provides
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return PokemonDatabase.getInstance(context)
    }

    @Provides
    fun providePokemonDao(appDatabase: PokemonDatabase): PokemonDao {
        return appDatabase.pokemonsDao()
    }



}

