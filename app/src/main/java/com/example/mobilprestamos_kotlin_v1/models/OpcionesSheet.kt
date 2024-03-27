package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class OpcionesSheet(
    val icon: ImageVector,
    val label: String,
    val ruta: String
){
    ///TODO General ///
    object detail: OpcionesSheet(
        Icons.Filled.Article, "Detalle", AppScreens.PrestamosDetail.route
    )

    ///TODO Clientes ///
    object Edit: OpcionesSheet(
        Icons.Default.Edit, "Editar", AppScreens.PrestamosDetail.route
    )
    object Contact: OpcionesSheet(
        Icons.Filled.Call, "Contactar", AppScreens.PrestamosDetail.route
    )
    object delete: OpcionesSheet(
        Icons.Filled.Delete, "Eliminar", AppScreens.PrestamosDetail.route
    )

    /// TODO PRESTAMOS ///
    object cobrar: OpcionesSheet(
        Icons.Filled.MonetizationOn, "Cobrar", AppScreens.PrestamosDetail.route
    )
    /// TODO PRESTAMOS Y COBROS ///
    object verRecibo: OpcionesSheet(
        Icons.Filled.Receipt, "Ver Recibo", AppScreens.PrestamosDetail.route
    )


}
