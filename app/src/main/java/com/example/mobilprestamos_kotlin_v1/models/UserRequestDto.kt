package com.example.mobilprestamos_kotlin_v1.models

import com.google.gson.annotations.SerializedName

data class UserRequestDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_rol")
    val id_rol: Int,
    @SerializedName("nombre")
    val nombre: String
)