package com.example.mobilprestamos_kotlin_v1.componentsUtils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.models.AppMenuNavigation
import com.example.mobilprestamos_kotlin_v1.navigations.CurrentRoute

@Composable
fun BottomBarApp(navController: NavHostController, itemsScreens: List<AppMenuNavigation>){
    val items_menu_inferior = itemsScreens

    BottomAppBar {
        NavigationBar(containerColor = colorResource(id = R.color.white)) {
            items_menu_inferior.forEach{item->
                val select_route = CurrentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = select_route,
                    onClick = {
                        navController.navigate("${item.ruta}${item.type}")
                              },
                    icon = { Icon( imageVector = item.icon, contentDescription = item.title) },
                    label = {
                        Text(text = item.title)
                    },
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}

