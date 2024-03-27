package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CurrentRoute(navController: NavHostController): String? =
    navController.currentBackStackEntryAsState().value?.destination?.route
