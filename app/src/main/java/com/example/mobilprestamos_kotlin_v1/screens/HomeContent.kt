

package com.example.mobilprestamos_kotlin_v1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.models.AppMenuLateralHome.*
import com.example.mobilprestamos_kotlin_v1.navigations.AppNavigationDrawer
import com.example.mobilprestamos_kotlin_v1.navigations.CurrentRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController){
    val navHostController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(drawerContent = {drawerContent(navHostController, drawerState) }, drawerState = drawerState) {
        Scaffold (
            topBar = {
                loadTopBar(drawerState = drawerState)
            }

        ){padding ->
            Box(modifier = Modifier
                .padding(padding)
                .fillMaxSize()) {
                AppNavigationDrawer(navHostController)
            }
        }

    }
    /*
        loadMenu(
            navController = navController,
            drawerState = drawerState,
        ){
            loadContent(drawerState = drawerState, navController = navController)
        }*/
}


@Composable
fun Image(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.user),
        contentDescription = "Header",
        modifier = modifier
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadTopBar(drawerState: DrawerState){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = { Text(text = context.getString(R.string.app_name_label),
            fontSize = 18.sp,
            color = colorResource(id = R.color.white))},
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.sl_dark_green)),
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                    // Toast.makeText(context, "presionaste el boton", Toast.LENGTH_LONG).show()
                }) {
                Icon(
                    Icons.Default.Menu, "Abrir menu", tint = Color.White
                    /* modifier = Modifier.clickable{
                         scope.launch {
                             drawerState.open()
                         }
                 }*/)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadMenu(navController: NavHostController,
             drawerState: DrawerState,
             contenido: @Composable ()-> Unit
){
    ModalNavigationDrawer(
        drawerContent = {drawerContent(navController, drawerState) },
        drawerState = drawerState)
    {
        contenido()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawerContent(navController: NavHostController, drawerState: DrawerState){
    val scope = rememberCoroutineScope()
    val itemsScreens = listOf(
        Home,
        ListaClientes,
        ListaPrestamos,
        ListaCobros,
        Caja
    )
    ModalDrawerSheet {
        Column (modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))){
            Image(
                painter = painterResource(id = R.drawable.logo),
                "",
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxWidth(),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Movil Prestamos",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    textAlign = TextAlign.Center
                )
            }
            Divider()
        }
        itemsScreens.forEach { item ->
            val select_route = CurrentRoute(navController) == item.ruta
            NavigationDrawerItem(label = { Text(text = item.title) },
                selected = select_route,
                onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate("${item.ruta}${item.type}")
                },
                icon = { Icon(item.icon, null)})
        }
    }
}