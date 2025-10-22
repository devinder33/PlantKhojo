package com.example.plantkhojo.presentation.ui.screens.characters

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantkhojo.core.common.Resource
import com.example.plantkhojo.domain.usecase.GetAllCharacterUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getAllCharacterUserCase: GetAllCharacterUserCase): ViewModel() {

    private val _characterState = MutableStateFlow(CharactersState())
    val characterState: MutableStateFlow<CharactersState> get() = _characterState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        getAllCharacterUserCase().onEach {
            when(it){
                is Resource.Loading -> {
                    _characterState.value = CharactersState().copy(isLoading = true)
                }
                is Resource.Success -> {
                    _characterState.value = CharactersState().copy(characters = it.data!!)
                }
                is Resource.Error -> {
                    _characterState.value = CharactersState().copy(errorMessage = it.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}