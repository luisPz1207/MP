package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdfScanner
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mobilprestamos_kotlin_v1.utils.Utils

sealed class AppMenuLateralHome(
    val icon: ImageVector,
    val title: String,
    val ruta: String,
    val type: String
){
    object Home: AppMenuLateralHome(
         Icons.Outlined.Home,
        "Home",
        AppScreens.Home.route,
        ""
    )
    object ListaClientes: AppMenuLateralHome(
        Icons.Outlined.AccountBox,
        "Clientes",
        AppScreens.ListaClientes.route,
        ""
    )
    object ListaPrestamos: AppMenuLateralHome(
        Icons.Outlined.Analytics,
        "Prestamos",
        AppScreens.ListaPrestamos.route,
        Utils.TYPE_PRESTAMOS_PENDIENTES.type
    )
    object ListaCobros: AppMenuLateralHome(
        Icons.Outlined.AttachMoney,
        "Cobros",
        AppScreens.Cobros.route,
        Utils.TYPE_COBROS_PENDIENTES.type
    )
    object Caja: AppMenuLateralHome(
        Icons.Filled.AdfScanner,
        "Caja",
        AppScreens.Caja.route,
        ""
    )
}
