package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.modulos.caja.Caja
import com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes.loadheader
import com.example.mobilprestamos_kotlin_v1.screens.modulos.cobros.Cobros
import com.example.mobilprestamos_kotlin_v1.screens.modulos.home.loadHome
import com.example.mobilprestamos_kotlin_v1.screens.modulos.prestamos.loadListaPrestamos

@Composable
fun AppNavigationDrawer(navController: NavHostController){
    NavHost(navController = navController,
        route = Graph.HOME,
        startDestination = AppScreens.Home.route,
    ) {
            composable(route = AppScreens.Home.route){
                loadHome(navController)
            }
            composable(route = AppScreens.ListaClientes.route){
                loadheader(navController)
            }
            composable(route = "${AppScreens.ListaPrestamos.route}{typeId}"){backStackEntry ->
                val typeId = backStackEntry.arguments?.getString("typeId")
                requireNotNull(typeId)
                loadListaPrestamos(navController, typeId)
            }
          /*  composable(route = AppScreens.PrestamosDetail.route){
                PrestamoDetail(navController)
            }*/
            composable(route = "${AppScreens.Cobros.route}{typeId}"){backStackEntry ->
                val typeId = backStackEntry.arguments?.getString("typeId")
                requireNotNull(typeId)
                Cobros(navController, typeId)
            }
            composable(route = AppScreens.Caja.route){
                Caja()
            }
            DetailNavigation(navController)
        }
}