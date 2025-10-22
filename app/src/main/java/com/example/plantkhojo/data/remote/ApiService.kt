package com.example.plantkhojo.data.remote

import com.example.plantkhojo.core.common.ApiUrls.GET_CHARACTERS
import com.example.plantkhojo.data.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // https://hp-api.onrender.com/api/characters

    @GET(GET_CHARACTERS)
    suspend fun getAllCharacters(): List<CharactersDto>
}