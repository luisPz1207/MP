package com.example.mobilprestamos_kotlin_v1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import kotlinx.coroutines.delay


@Preview
@Composable
fun splash(navController: NavHostController){
    LaunchedEffect(key1 = true){
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.Login.route)
    }

    Box (modifier =
    Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(30.dp),
    contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Header",
            modifier = Modifier.align(Alignment.Center)
        )

    }
}