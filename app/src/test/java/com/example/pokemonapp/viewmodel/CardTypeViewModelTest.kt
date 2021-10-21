package com.example.pokemonapp.viewmodel

import com.example.domain.entity.TypeData
import com.example.domain.repository.PokemonRepository
import com.example.domain.usecase.PokemonUseCase
import com.example.domain.usecase.PokemonUseCaseImpl
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CardTypeViewModelTest : BaseViewModelTest() {

    private lateinit var useCase: PokemonUseCase
    private val typeRepository: PokemonRepository = mock()
    private lateinit var viewModel: CardTypeViewModel
    private lateinit var typeData: TypeData
    private lateinit var flowTypeData: Flow<TypeData>
    private lateinit var successResponseList: List<CardTypeViewModel.CardTypeData>
    private lateinit var errorResponseList: List<CardTypeViewModel.CardTypeData>

    @Before
    override fun `set up`() {
        super.`set up`()
        useCase = PokemonUseCaseImpl(typeRepository)
        viewModel = CardTypeViewModel(useCase)
    }

    @Test
    fun `get types test success`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        typeData = TypeData(mutableListOf(STRING_TYPE))
        flowTypeData = flowOf(typeData)
        whenever(typeRepository.getTypesInformationApi()).thenReturn(flowTypeData)
        successResponseList = listOf(
            CardTypeViewModel.CardTypeData(responseType = CardTypeViewModel.CardTypeStatus.LOADING),
            CardTypeViewModel.CardTypeData(responseType = CardTypeViewModel.CardTypeStatus.SUCCESSFUL, data = typeData)
        )

        runBlocking {
            viewModel.getTypes().join()
        }

        verify(typeRepository).getTypesInformationApi()
        assertEquals(
            successResponseList[FIRST_RESPONSE].responseType,
            liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            successResponseList[SECOND_RESPONSE].responseType,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            successResponseList[SECOND_RESPONSE].data,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.data
        )
    }

    @Test
    fun `get types test error`() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()
        typeData = TypeData(emptyList())
        flowTypeData = flowOf(typeData)
        whenever(typeRepository.getTypesInformationApi()).thenReturn(flowTypeData)
        errorResponseList = listOf(
            CardTypeViewModel.CardTypeData(responseType = CardTypeViewModel.CardTypeStatus.LOADING),
            CardTypeViewModel.CardTypeData(responseType = CardTypeViewModel.CardTypeStatus.ERROR, error = NO_TYPES_MESSAGE)
        )

        runBlocking {
            viewModel.getTypes().join()
        }

        verify(typeRepository).getTypesInformationApi()
        assertEquals(
            errorResponseList[FIRST_RESPONSE].responseType,
            liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            errorResponseList[SECOND_RESPONSE].responseType,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.responseType
        )
        assertEquals(
            errorResponseList[SECOND_RESPONSE].error,
            liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent()?.error
        )
    }

    companion object {
        private const val NO_TYPES_MESSAGE: String = "No types found"
        private const val STRING_TYPE: String = "Type"
        private const val FIRST_RESPONSE: Int = 0
        private const val SECOND_RESPONSE: Int = 1
    }
}
