package com.example.domain.repository

import com.example.domain.entity.TypeData
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getTypesInformationApi(): Flow<TypeData>
}
