package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mobilprestamos_kotlin_v1.utils.Globals

sealed class OpcionesSheet(
    val icon: ImageVector,
    val label: String,
    val ruta: String,
    val typeAction: String
){
    ///TODO General ///
    object detailPrestamo: OpcionesSheet(
        Icons.Filled.Article,
        "Detalle",
        AppScreens.PrestamosDetail.route,
        Globals.DETALLE
    )object detailCobro: OpcionesSheet(
        Icons.Filled.Article, "Detalle", AppScreens.Cobros.route, Globals.DETALLE
    )object detailCliente: OpcionesSheet(
        Icons.Filled.Article, "Detalle", AppScreens.ClientesDetalle.route, Globals.DETALLE
    )

    ///TODO Clientes ///
    object Edit: OpcionesSheet(
        Icons.Default.Edit, "Editar",
        AppScreens.CrearCliente.route,  Globals.EDITAR
    )
    object Contact: OpcionesSheet(
        Icons.Filled.Call, "Contactar", AppScreens.PrestamosDetail.route, Globals.CONTACTAR
    )
    object delete: OpcionesSheet(
        Icons.Filled.Delete, "Eliminar", AppScreens.PrestamosDetail.route, Globals.ELIMINAR
    )

    /// TODO PRESTAMOS ///
    object cobrar: OpcionesSheet(
        Icons.Filled.MonetizationOn, "Cobrar",
        AppScreens.PrestamosDetail.route, Globals.COBRAR
    )
    /// TODO PRESTAMOS Y COBROS ///
    object verRecibo: OpcionesSheet(
        Icons.Filled.Receipt, "Ver Recibo",
        AppScreens.PrestamosDetail.route,  Globals.RECIBO
    )


}
