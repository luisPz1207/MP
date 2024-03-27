package com.example.mobilprestamos_kotlin_v1.models

sealed class ListLoans(
    var name: String,
    var activo: Boolean,
    var amount: String,
    var cuotasPagadas: String,
    var cuotasPendientes : String,
    var cuotaAtrasada: String
){
    object items: ListLoans(
        "El negro",
        true,
        "$20,000.00",
        "1",
        "4",
        "0"
    )
    object items_2: ListLoans(
        "El coba",
        true,
        "$20,000.00",
        "3",
        "4",
        "0"
    )
    object items_3: ListLoans(
        "castalamares",
        false,
        "$20,000.00",
        "2",
        "4",
        "1"
    )
    object items_4: ListLoans(
        "tangalangalan",
        false,
        "$20,000.00",
        "0",
        "4",
        "2"
    )
}
