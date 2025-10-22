package com.example.plantkhojo.presentation.ui.screens.characters

import com.example.plantkhojo.domain.model.Characters

data class CharactersState(
    val characters: List<Characters> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)