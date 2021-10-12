package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.TypeData
import com.example.domain.usecase.PokemonUseCase
import com.example.pokemonapp.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardTypeViewModel(private val pokemonUseCase: PokemonUseCase) : ViewModel() {

    private var mutableCardTypeState: MutableLiveData<Event<CardTypeData>> = MutableLiveData()

    fun getLiveDataState(): LiveData<Event<CardTypeData>> = mutableCardTypeState

    fun getTypes() = viewModelScope.launch {
        mutableCardTypeState.postValue(Event(CardTypeData(responseType = CardTypeStatus.LOADING)))
        val result: Flow<TypeData> = withContext(Dispatchers.IO) { pokemonUseCase() }
        result.collect {
            if (it.data.isNotEmpty()) {
                mutableCardTypeState.postValue(Event(CardTypeData(responseType = CardTypeStatus.SUCCESSFUL, data = it)))
            } else {
                mutableCardTypeState.postValue(Event(CardTypeData(responseType = CardTypeStatus.ERROR, error = NO_TYPES_MESSAGE)))
            }
        }
    }

    companion object {
        private const val NO_TYPES_MESSAGE: String = "No types found"
        private const val ERROR_DEFAULT: String = "Error default"
    }

    data class CardTypeData(var responseType: CardTypeStatus, var data: TypeData = TypeData(), var error: String = ERROR_DEFAULT)

    enum class CardTypeStatus { SUCCESSFUL, ERROR, LOADING }
}
