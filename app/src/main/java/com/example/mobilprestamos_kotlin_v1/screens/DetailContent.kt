package com.example.mobilprestamos_kotlin_v1.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.modulos.prestamos.PrestamoDetail

@Composable
fun DetailContent(navController: NavHostController, route: String){
        if(route.equals(AppScreens.HomeContent.route)){
              Home(navController = navController)  
        }else if(route.equals(AppScreens.PrestamosDetail.route)){
               PrestamoDetail(navController = navController)
        }
        

}