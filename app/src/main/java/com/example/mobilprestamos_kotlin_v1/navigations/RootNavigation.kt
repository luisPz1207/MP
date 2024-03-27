package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.Home

@Composable
fun RootNavigation(navController: NavHostController){
    NavHost(navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.LOGIN,
    ) {
        LoginNavigation(navController = navController)
        composable(route = AppScreens.HomeContent.route){
            Home(navController)
        }

      }
}


object Graph {
    const val ROOT = "root_graph"
    const val LOGIN = "login_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}