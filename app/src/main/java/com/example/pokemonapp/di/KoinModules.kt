package com.example.pokemonapp.di

import com.example.pokemonapp.viewmodel.CardTypeViewModel
import com.example.pokemonapp.viewmodel.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SplashScreenViewModel() }
    viewModel { CardTypeViewModel(get()) }
}
