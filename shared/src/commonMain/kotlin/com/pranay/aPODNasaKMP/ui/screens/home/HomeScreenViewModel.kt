package com.pranay.aPODNasaKMP.ui.screens.home

import com.pranay.aPODNasaKMP.domain.NetworkResultState
import com.pranay.aPODNasaKMP.domain.isLoading
import com.pranay.aPODNasaKMP.domain.onFailure
import com.pranay.aPODNasaKMP.domain.onSuccess
import com.pranay.aPODNasaKMP.domain.usecase.GetAPODNasaMediaListUseCase
import com.pranay.aPODNasaKMP.krouter.SavedStateHandle
import com.pranay.aPODNasaKMP.krouter.ViewModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class HomeScreenViewModel(private val savedState: SavedStateHandle):ViewModel() {
    private val nasaAPODNasaMediaListUseCase: GetAPODNasaMediaListUseCase by inject()
    private val _state: MutableStateFlow<HomeUiState> =
        MutableStateFlow(savedState.get() ?: HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        fetchAPODNasaPictures()
        saveStateUpdates()
    }

    private fun fetchAPODNasaPictures() = CoroutineScope(coroutineContext).launch {
        when(val result = nasaAPODNasaMediaListUseCase.invoke(25))
        {
            is NetworkResultState.Loading -> {
                Napier.i("State:Loading")
                result.isLoading {isLoading->
                    _state.update { it.copy(isLoading = isLoading) }
                }
            }
            is NetworkResultState.Success -> {
                Napier.i("State:Success")
                result.onSuccess { apodPictureItemList ->
                    _state.update { it.copy(apodPictureItemList = apodPictureItemList, isLoading = false) }
                }
            }
            is NetworkResultState.Failure -> {
                Napier.i("State:Failure")
                result.onFailure { error ->
                    _state.update { it.copy(error = error.message) }
                }
            }
        }
    }

    private fun saveStateUpdates() {
        launch {
            state.collectLatest {
                savedState.set(it)
            }
        }
    }
}