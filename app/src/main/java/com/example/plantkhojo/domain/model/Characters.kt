package com.example.plantkhojo.domain.model

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("actor")
    val actor: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
)