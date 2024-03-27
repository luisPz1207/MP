package com.example.mobilprestamos_kotlin_v1.models

sealed class ListAccounts(
    var name: String,
    var address: String,
    var amount: String
){
    object items_Accounts: ListAccounts(
        "El negro","la matica","$2,000,000.00"
    )
    object items_Accounts2: ListAccounts(
        "El coba","villacon","$2,000,000.00"
    )
    object items_Accounts3: ListAccounts(
        "Tony castalamares","el millon","$2,000,000.00"
    )
    object items_Accounts4: ListAccounts(
        "la multi","pais de las maravillas","$2,000,000.00"
    )
}
