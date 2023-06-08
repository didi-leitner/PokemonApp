package com.didi.pokemon.app.di

import com.didi.pokemon.app.network.IPokemonApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val baseUrl = "https://pokeapi.co/api/v2/"
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {



    @Provides
    fun provideGson():Gson{
        return Gson()
    }

    @Provides
    fun providesHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)



        //LOGGING
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        okhttpClientBuilder.interceptors().add(logging)


        return okhttpClientBuilder.build()
    }
    @Provides
    fun providePokemonApi(gson: Gson, client: OkHttpClient): IPokemonApi {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(IPokemonApi::class.java)
    }
}