package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.DetailContent
import com.example.mobilprestamos_kotlin_v1.screens.Home
import com.example.mobilprestamos_kotlin_v1.screens.modulos.login.loadviews
import com.example.mobilprestamos_kotlin_v1.screens.splash

fun NavGraphBuilder.LoginNavigation(navController: NavHostController){
    navigation(route = Login.LOGIN,
        startDestination = AppScreens.Splash.route,
    ) {
        composable(route = AppScreens.Login.route){
            loadviews(navController)
        }
        composable(route = AppScreens.Content.route){
            DetailContent(navController, AppScreens.HomeContent.route)
        }
        composable(route = AppScreens.HomeContent.route){
            Home(navController) }
        composable(route = AppScreens.Splash.route){
            splash(navController)
        }
        DetailNavigation(navController)
    }
}


object Login {
    const val ROOT = "root_graph"
    const val LOGIN = "login_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}