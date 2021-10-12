package com.example.data.service

import com.example.data.BuildConfig
import com.example.data.api.PokemonApi
import com.example.data.response.TypeResponse
import com.example.domain.utils.Result

class PokemonService {

    private val pokemonRequestGenerator = PokemonRequestGenerator()

    fun getTypesInformationApi(): Result<TypeResponse> = try {
        val response = pokemonRequestGenerator.generateRequest(PokemonApi::class.java).getResponseTypes(BuildConfig.API_KEY).execute()
        if (response.isSuccessful) {
            response.body()?.let { Result.Success(it) } ?: Result.Failure(Exception(NO_BODY_MESSAGE))
        } else {
            Result.Failure(Exception(response.message()))
        }
    } catch (e: Exception) {
        Result.Failure(Exception(EXCEPTION_MESSAGE))
    }

    companion object {
        private const val NO_BODY_MESSAGE: String = "No body"
        private const val EXCEPTION_MESSAGE: String = "Request error"
    }
}
