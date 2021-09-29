package com.example.pokemonapp

import android.app.Application
import com.example.pokemonapp.di.viewModelsModule
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelsModule))
        }
    }
}
