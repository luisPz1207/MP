package com.example.mobilprestamos_kotlin_v1.models

//@Parcelize
//@Serializable
data class MLClientes(
    val apellido: String,
    val cedula: String,
    val cliente: String,
    val correo: String,
    val creado_por: Int,
    val direccion: String,
    val identificacion_garante: String,
    val ingresos: Int,
    val lugar_trabajo: String,
    val nombre: String,
    val ocupacion: String,
    val telefono1: String,
    val telefono2: String,
    val user_log: Int,
    val id_cliente: String
)/*: Parcelable*/{
    companion object{
        const val KEY_APELLIDO = "apellido"
        const val KEY_CEDULA = "cedula"
        const val KEY_NOMBRE ="nombre"
        const val KEY_CLIENTE = "cliente"
        const val KEY_CORREO = "correo"
        const val KEY_CREADO_POR = "creado_por"
        const val KEY_DIRECCION = "direccion"
        const val KEY_IDENTIFICACION_GARANTE = "identificacion_garante"
        const val KEY_INGRESOS = "ingresos"
        const val KEY_LUGAR_TRABAJO = "lugar_trabajo"
        const val KEY_OCUPACION = "ocupacion"
        const val KEY_TELEFNO1 = "telefono1"
        const val KEY_TELEFONO2 = "telefono2"
        const val KEY_USER_LOG = "user_log"
        const val KEY_ID_CLIENTE = "id_cliente"
    }
}
