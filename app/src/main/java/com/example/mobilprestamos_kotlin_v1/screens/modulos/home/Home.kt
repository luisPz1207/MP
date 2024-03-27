

package com.example.mobilprestamos_kotlin_v1.screens.modulos.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews
import com.example.mobilprestamos_kotlin_v1.models.AppMenuLateralHome
import com.example.mobilprestamos_kotlin_v1.navigations.CurrentRoute

@Composable
fun loadHome(navController: NavHostController){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Scaffold(
        bottomBar = {
            BottomAppBarHome(navController)
        }
    ){padding ->
      Box(modifier = Modifier
          .padding(padding)
          .fillMaxSize()){
          contenidoHome(navController = navController)
      }
    }


}

@Composable
fun contenidoHome(navController: NavController){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.white))
        .padding(15.dp)){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.AccountCircle, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = colorResource(id = R.color.blue_200)
                                )
                                spaceViews(value = 10)
                                Text(text = "20", fontSize = 30.sp)
                            }
                            spaceViews(value = 3)
                            Text(text = "Total Clientes", fontSize = 15.sp)

                        }
                    }
                    spaceViews(value = 20)
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.Money, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = colorResource(id = R.color.teal_50_200)
                                )
                                spaceViews(value = 10)
                                Text(text = "10", fontSize = 30.sp)
                            }

                            spaceViews(value = 3)
                            Text(text = "Total Prestamos", fontSize = 15.sp)
                        }
                    }

                }

                //// segundo roe padre///
                spaceViews(value = 30)
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.MonetizationOn, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = Color.Green
                                )
                                spaceViews(value = 10)
                                Text(text = "20", fontSize = 30.sp)
                            }
                            spaceViews(value = 3)
                            Text(text = "Total Clientes", fontSize = 15.sp)

                        }
                    }
                    spaceViews(value = 20)
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.Analytics, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = Color.Red
                                )
                                spaceViews(value = 10)
                                Text(text = "10", fontSize = 30.sp)
                            }

                            spaceViews(value = 3)
                            Text(text = "Total Prestamos", fontSize = 15.sp)
                        }
                    }

                }
                
                ////tercer row padre///
                spaceViews(value = 30)
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.Settings, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = colorResource(id = R.color.deep_purple)
                                )
                                spaceViews(value = 10)
                                Text(text = "20", fontSize = 30.sp)
                            }
                            spaceViews(value = 3)
                            Text(text = "Total Clientes", fontSize = 15.sp)

                        }
                    }
                    spaceViews(value = 20)
                    OutlinedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                        modifier = Modifier
                            .width(150.dp)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                    ) {
                        Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.Analytics, "accounts",
                                    modifier = Modifier
                                        .width(40.dp)
                                        .height(40.dp),
                                    tint = colorResource(id = R.color.blue_200)
                                )
                                spaceViews(value = 10)
                                Text(text = "10", fontSize = 30.sp)
                            }

                            spaceViews(value = 3)
                            Text(text = "Total Prestamos", fontSize = 15.sp)
                        }
                    }

                }

            }
    }
}

@Composable
fun BottomAppBarHome(navController: NavHostController){
    val items_menu_inferior = listOf(
        AppMenuLateralHome.Home,
        AppMenuLateralHome.ListaClientes,
        AppMenuLateralHome.ListaPrestamos,
        AppMenuLateralHome.ListaCobros,
    )
    BottomAppBar {
        NavigationBar(containerColor = colorResource(id = R.color.white)) {
            items_menu_inferior.forEach { item ->
                val select_route = CurrentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = select_route,
                    onClick = { navController.navigate(item.ruta + item.type) },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }
}
