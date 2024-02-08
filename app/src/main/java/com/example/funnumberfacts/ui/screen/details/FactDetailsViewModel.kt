package com.example.funnumberfacts.ui.screen.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnumberfacts.data.NumberFact
import com.example.funnumberfacts.repository.NumberFactRepository
import com.example.funnumberfacts.ui.navigation.FACT_ID
import com.example.funnumberfacts.util.orInvalidId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val factRepository: NumberFactRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(ItemDetailsScreenState())
    val viewState: StateFlow<ItemDetailsScreenState> = _viewState.asStateFlow()

    private val factId = savedStateHandle.get<Int>(FACT_ID).orInvalidId()

    init {
        getItemDetails()
    }

    private fun getItemDetails() {
        viewModelScope.launch {
            runCatching {
                factRepository.getFactById(factId)
            }.onSuccess { item ->
                _viewState.update { it.copy(fact = item) }
            }.onFailure {
                Log.d("$$$", "erorr $it")
            }
        }
    }
}

data class ItemDetailsScreenState(
    val fact: NumberFact? = null,

    )