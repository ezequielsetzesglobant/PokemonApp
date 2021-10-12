package com.example.di

import com.example.data.database.PokemonDataBase
import com.example.data.repository.PokemonRepositoryImpl
import com.example.data.service.PokemonService
import com.example.domain.repository.PokemonRepository
import com.example.domain.usecase.PokemonUseCase
import com.example.domain.usecase.PokemonUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    single<PokemonUseCase> { PokemonUseCaseImpl(get()) }
}

val repositoriesModule = module {
    factory { PokemonService() }
    single { PokemonDataBase.getInstance(get()) }
    single { get<PokemonDataBase>().pokemonDao() }
    factory<PokemonRepository> { PokemonRepositoryImpl(get(), get()) }
}
