package com.example.pokemonapp

import android.app.Application
import com.example.di.repositoriesModule
import com.example.di.useCasesModule
import com.example.pokemonapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonApplication)
            modules(listOf(viewModelsModule, useCasesModule, repositoriesModule))
        }
    }
}
