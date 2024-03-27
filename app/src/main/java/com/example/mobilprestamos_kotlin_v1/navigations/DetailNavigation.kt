package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.DetailContent
import com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes.AccountCreated
import com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes.DetailsAccount
import com.example.mobilprestamos_kotlin_v1.screens.modulos.prestamos.PrestamoDetail


fun NavGraphBuilder.DetailNavigation(navController: NavHostController){
    navigation(route = Graph.DETAILS,
        startDestination = AppScreens.PrestamosDetail.route,
    ) {
        composable(route = AppScreens.PrestamosDetail.route){
            DetailContent(navController, AppScreens.PrestamosDetail.route)
        }
        composable(route = AppScreens.ClientesDetalle.route){
            DetailsAccount()
        }
        composable(route = AppScreens.CrearCliente.route){
            AccountCreated(navController)
        }

    }
}

@Composable
fun DetailNavigationApp(navController: NavHostController){
    NavHost(navController = navController,
        route = Graph.DETAILS,
        startDestination = AppScreens.PrestamosDetail.route,
    ) {
        composable(route = AppScreens.PrestamosDetail.route){
            PrestamoDetail(navController)
        }
        composable(route = AppScreens.ClientesDetalle.route){
            DetailsAccount()
        }
        composable(route = AppScreens.CrearCliente.route){
            AccountCreated(navController)
        }
    }
}
