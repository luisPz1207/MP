package com.example.mobilprestamos_kotlin_v1.utils

enum class Utils (val type: String){
    TYPE_COBROS_PENDIENTES( "CP"),
    TYPE_COBROS_REALIZADOS( "CR"),
    TYPE_COBROS_VENCIDOS( "CV"),
    TYPE_PRESTAMOS_VENCIDOS( "PV"),
    TYPE_PRESTAMOS_REALIZADOS( "PR"),
    TYPE_PRESTAMOS_PENDIENTES( "PP"),
}