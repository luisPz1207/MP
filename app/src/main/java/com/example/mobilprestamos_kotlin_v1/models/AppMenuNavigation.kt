package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mobilprestamos_kotlin_v1.utils.Utils

sealed class AppMenuNavigation(
    val icon: ImageVector,
    val title: String,
    val ruta: String,
    val type: String
){
    ///// PRESTAM0S ////
    object ListaPrestamosPendientes: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Pendientes",
        AppScreens.ListaPrestamos.route,
        Utils.TYPE_PRESTAMOS_PENDIENTES.type
    )
    object ListaPrestamosRealizados: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Realizados",
        AppScreens.ListaPrestamos.route,
        Utils.TYPE_PRESTAMOS_REALIZADOS.type
    )

    object ListaPrestamosVencidos: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Vencidos",
        AppScreens.ListaPrestamos.route,
        Utils.TYPE_PRESTAMOS_VENCIDOS.type
    )

    ///// COBROS ////
    object ListaCobrosPendientes: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Pendientes",
        AppScreens.Cobros.route,
        Utils.TYPE_COBROS_PENDIENTES.type
    )

    object ListaCobrosRealizados: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Realizados",
        AppScreens.Cobros.route,
        Utils.TYPE_COBROS_REALIZADOS.type
    )
    object ListaCobrosVencidos: AppMenuNavigation(
        Icons.Outlined.AttachMoney,
        "Vencidos",
        AppScreens.Cobros.route,
        Utils.TYPE_COBROS_VENCIDOS.type
    )
}
