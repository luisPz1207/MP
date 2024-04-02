package com.example.mobilprestamos_kotlin_v1.models

data class Accounts(
    val apellido: String,
    val correo: Any,
    val creado_por: Int,
    val direccion: String,
    val eliminado_por: Any,
    val fecha_creacion: String,
    val fecha_eliminacion: Any,
    val fecha_modificacion: Any,
    val id: Int,
    val identificacion: String,
    val identificacion_garante: Any,
    val ingresos: Any,
    val lugar_de_trabajo: Any,
    val modificado_por: Any,
    var nombre: String,
    val ocupacion: Any,
    val telefono1: String,
    val telefono2: Any,
    val telefono_trabajo: Any
)

val cliente0 = Accounts(
    "",
    "",
    0,
    "" ,
    1,
    "",
    "",
    0,
    1 ,
    "",
    "" ,
    "",
    "",
    0,
    "",
    "",
    "",
    "",
    ""
)

