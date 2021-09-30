package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.utils.Event
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenViewModel : ViewModel() {

    private var mutableSplashScreenState: MutableLiveData<Event<SplashScreenStatus>> = MutableLiveData()

    fun getLiveDataState(): LiveData<Event<SplashScreenStatus>> = mutableSplashScreenState

    fun navigateToMainFragment() = viewModelScope.launch {
        mutableSplashScreenState.postValue(Event(SplashScreenStatus.LOADING))
        withContext(IO) {
            delay(WAIT_TIME)
            mutableSplashScreenState.postValue(Event(SplashScreenStatus.NAVIGATE))
        }
    }

    companion object {
        private const val WAIT_TIME: Long = 4000
    }

    enum class SplashScreenStatus { LOADING, NAVIGATE }
}
