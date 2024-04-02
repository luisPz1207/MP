package com.example.mobilprestamos_kotlin_v1.models

sealed class AppScreens(val route: String){
    object Splash: AppScreens("splash_screen")
    object Login: AppScreens("login_screen")
    object Content: AppScreens("content_screen")
    object Home: AppScreens("home_screen")
    object HomeContent: AppScreens("home_content_screen")
    object ListaClientes: AppScreens("accounts_screen")
    object ClientesDetalle: AppScreens("accounts_detail_screen/")
    object CrearCliente: AppScreens("accounts_created_screen/")
    object ListaPrestamos: AppScreens("prestamos_screen/")
    object PrestamosDetail: AppScreens("prestamos_detail_screen")
    object Cobros: AppScreens("cobros_screen/")
    object Caja: AppScreens("caja_screen")
}
