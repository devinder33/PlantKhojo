package com.example.plantkhojo.domain.repository

import com.example.plantkhojo.core.common.Resource
import com.example.plantkhojo.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacters(): Flow<Resource<List<Characters>>>
}