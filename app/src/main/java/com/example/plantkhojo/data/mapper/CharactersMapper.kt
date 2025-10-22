package com.example.plantkhojo.data.mapper

import com.example.plantkhojo.data.dto.CharactersDto
import com.example.plantkhojo.domain.model.Characters

fun CharactersDto.toDomainCharacter(): Characters {
    return Characters(
        id = id,
        name = name,
        actor = actor,
        image = image
    )
}