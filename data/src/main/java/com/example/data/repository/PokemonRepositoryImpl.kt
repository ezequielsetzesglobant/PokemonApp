package com.example.data.repository

import com.example.data.database.PokemonDataBase
import com.example.data.mapper.transformEntityToData
import com.example.data.mapper.transformResponseToEntity
import com.example.data.service.PokemonService
import com.example.domain.entity.TypeData
import com.example.domain.repository.PokemonRepository
import com.example.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonRepositoryImpl(private val pokemonService: PokemonService, private val pokemonDataBase: PokemonDataBase) : PokemonRepository {

    override fun getTypesInformationApi(): Flow<TypeData> = with(pokemonService.getTypesInformationApi()) {
        when (this) {
            is Result.Success -> {
                pokemonDataBase.pokemonDao().insertTypes(this.data.transformResponseToEntity())
                pokemonDataBase.pokemonDao().getTypes().map { it.transformEntityToData() }
            }
            is Result.Failure -> {
                pokemonDataBase.pokemonDao().getTypes().map { it.transformEntityToData() }
            }
        }
    }
}
