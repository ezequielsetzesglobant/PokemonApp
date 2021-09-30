package com.example.pokemonapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SplashScreenViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SplashScreenViewModel
    private val responseList: List<SplashScreenViewModel.SplashScreenStatus> =
        listOf(SplashScreenViewModel.SplashScreenStatus.LOADING, SplashScreenViewModel.SplashScreenStatus.NAVIGATE)

    @Before
    fun seTup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = SplashScreenViewModel()
    }

    @After
    fun after() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun navigateToMainFragmentTest() {
        val liveDataUnderTest = viewModel.getLiveDataState().testObserver()

        runBlocking {
            viewModel.navigateToMainFragment().join()
        }

        assertEquals(responseList[FIRST_RESPONSE], liveDataUnderTest.observedValues[FIRST_RESPONSE]?.peekContent())
        assertEquals(responseList[SECOND_RESPONSE], liveDataUnderTest.observedValues[SECOND_RESPONSE]?.peekContent())
    }

    companion object {
        private const val FIRST_RESPONSE: Int = 0
        private const val SECOND_RESPONSE: Int = 1
    }
}
