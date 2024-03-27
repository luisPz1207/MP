package com.example.mobilprestamos_kotlin_v1.models

sealed class listCollection(
    var name: String,
    var address: String,
    var amount: String,
    var amount_pending: String
){
    object items: listCollection(
        "El negro","la matica","$2,000,000.00", "0.00"
    )
    object items_2: listCollection(
        "El coba","villacon","$2,000,000.00", "0.00"
    )
    object items_3: listCollection(
        "Tony castalamares","el millon","$2,000,000.00", "0.00"
    )
    object items_4: listCollection(
        "la multi","pais de las maravillas","$2,000,000.00", "0.00"
    )
    object items_5: listCollection(
        "la multi","pais de las maravillas","$2,000,000.00", "0.00"
    )
}
