package com.example.plantkhojo.domain.usecase

import com.example.plantkhojo.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUserCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke() = repository.getAllCharacters()
}