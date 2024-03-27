package com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.BottomSheet
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loadList
import com.example.mobilprestamos_kotlin_v1.models.AppMenuLateralHome
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.models.ListAccounts.*
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.*
import com.example.mobilprestamos_kotlin_v1.navigations.CurrentRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun loadheader(navController: NavHostController){
    loadViews(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadViews(navController: NavHostController){
    val label = LocalContext.current.getString(R.string.clientes)
    val scope = rememberCoroutineScope()
    val items = listOf(
        items_Accounts,
        items_Accounts2,
        items_Accounts3,
        items_Accounts4
    )
    val mainViewModel: MainViewModel = viewModel()
    val listOpciones = listOf(
        detail,
        Edit,
        cobrar,
        verRecibo
    )

    Scaffold(
       /* topBar = {
            TopBarBackPress(navController, label)
        },*/
        floatingActionButton = {
            FabBottom(scope = scope, navController = navController)
                               },
       bottomBar = {
           bottomBar(navController)
       }
    ){padding ->
        Box(modifier = androidx.compose.ui.Modifier
            .padding(padding)
            .fillMaxSize()) {
            loadList(navController = navController, list = items)
            if(mainViewModel.showBottomSheet) {
                BottomSheet(navController = navController, listOpciones)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomBar(navController: NavHostController){
    val items_menu_inferior = listOf(
        AppMenuLateralHome.Home,
        AppMenuLateralHome.ListaClientes,
        AppMenuLateralHome.ListaPrestamos,
        AppMenuLateralHome.ListaCobros,
    )

    BottomAppBar {
        NavigationBar(containerColor = colorResource(id = R.color.white)) {
            items_menu_inferior.forEach{item->
                val select_route = CurrentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = select_route,
                    onClick = { navController.navigate(item.ruta+item.type) },
                    icon = {Icon( imageVector = item.icon, contentDescription = item.title)},
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }

}


@Composable
fun FabBottom(scope: CoroutineScope, navController: NavHostController){
    var navDetail by remember {
        mutableStateOf(false)
    }
    FloatingActionButton(onClick = {
        scope.launch {
            navController.navigate(AppScreens.CrearCliente.route)
        }
    },
        shape = CircleShape,
        modifier = Modifier.offset(y = 40.dp),
        containerColor =  (colorResource(id = R.color.sl_dark_green)),
        contentColor = (colorResource(id = R.color.white))) {
        Icon(Icons.Filled.Add , contentDescription = "New")
    }
}

/*
@Composable
fun loadListAccounts(){
    val listAccounts = listOf(
        ListAccounts.items_Accounts,
        ListAccounts.items_Accounts2,
        ListAccounts.items_Accounts3,
        ListAccounts.items_Accounts4,
    )
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(listAccounts){item->
            rows(item)
            Divider()
        }
    }
}*/
/*
@Composable
fun rows(item: ListAccounts){
    val masInfo = remember {
        mutableStateOf(false)
    }
    Column (modifier = Modifier
        .animateContentSize(
            animationSpec = tween(120, 0, LinearEasing)
        )
        .background(colorResource(id = R.color.orange50))
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = {
                masInfo.value = !masInfo.value
            }) {
                Icon(
                    if (masInfo.value) Icons.Default.Remove
                    else Icons.Default.Add, contentDescription = "mas información"
                )
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = item.address,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(1f)
            )
        }

        if(masInfo.value){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.amount,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}
 */