package com.example.domain.usecase

import com.example.domain.entity.TypeData
import com.example.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {

    operator fun invoke(): Flow<TypeData>
}

class PokemonUseCaseImpl(private val pokemonRepository: PokemonRepository) : PokemonUseCase {

    override operator fun invoke(): Flow<TypeData> = pokemonRepository.getTypesInformationApi()
}
