package com.example.mobilprestamos_kotlin_v1.models

import com.google.gson.annotations.SerializedName

data class UsuariosList(
    @SerializedName("contrasena")
    val contrasena: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("creado_por")
    val creado_por: Int,
    @SerializedName("eliminado_por")
    val eliminado_por: Any,
    @SerializedName("fecha_creacion")
    val fecha_creacion: String,
    @SerializedName("fecha_eliminacion")
    val fecha_eliminacion: Any,
    @SerializedName("fecha_modificacion")
    val fecha_modificacion: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("id_rol")
    val id_rol: Int,
    @SerializedName("modificado_por")
    val modificado_por: Any,
    @SerializedName("nombre")
    val nombre: String
)