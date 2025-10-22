package com.example.plantkhojo.data.repository

import com.example.plantkhojo.core.common.Resource
import com.example.plantkhojo.data.mapper.toDomainCharacter
import com.example.plantkhojo.data.remote.ApiService
import com.example.plantkhojo.domain.model.Characters
import com.example.plantkhojo.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: ApiService) : CharacterRepository {

    override fun getAllCharacters(): Flow<Resource<List<Characters>>> = flow {
        emit(Resource.Loading())
        val result: List<Characters> = apiService.getAllCharacters().map { it.toDomainCharacter() }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message ?: "Unknown error"))
        }
}