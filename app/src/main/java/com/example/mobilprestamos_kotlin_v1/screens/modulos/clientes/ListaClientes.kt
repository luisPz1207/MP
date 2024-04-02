package com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loaderProgress
import com.example.mobilprestamos_kotlin_v1.models.AccountsViewModel
import com.example.mobilprestamos_kotlin_v1.models.AppMenuLateralHome
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.Contact
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.Edit
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.delete
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.detailCliente
import com.example.mobilprestamos_kotlin_v1.navigations.CurrentRoute
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun loadheader(navController: NavHostController){
    val accountsViewModel: AccountsViewModel = viewModel()

    loadViews(navController, accountsViewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun loadViews(navController: NavHostController, accountsViewModel: AccountsViewModel){
    val label = LocalContext.current.getString(R.string.clientes)
    var valueFilter by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val service = ApiService.instance
    val items by accountsViewModel._list_Accounts.observeAsState()
    val mainViewModel: MainViewModel = viewModel()

    val listOpciones = listOf(
        detailCliente,
        Edit,
        Contact,
        delete
    )

    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

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
/*
            SearchBar(query = query,
                onQueryChange = {query = it},
                onSearch = {},
                active = active,
                onActiveChange = {active = it}
            ) {
                val filterCli = clientes.filter { it.contains(query, true) }
                filterCli.forEach{item->
                    Text(text = item)
                }
            }*/

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {

                OutlinedTextField(
                    value = valueFilter,
                    onValueChange = {valueFilter = it},
                    label = { Text(LocalContext.current.getString(R.string.clientes)) },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                scope.launch{
                                    accountsViewModel.filtrarClientes(valueFilter)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Clear"
                            )
                        }
                    }
                )
                if(accountsViewModel.showList) {
                    items?.let { loadList(navController = navController, list = it) }
                }
                if(mainViewModel.showLoaderProgress){
                    loaderProgress()
                }
                if(mainViewModel.showBottomSheet) {
                    BottomSheet(navController = navController, listOpciones)
                }
            }


        }
    }
}

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
            navController.navigate(AppScreens.CrearCliente.route+"0")
        }
    },
        shape = CircleShape,
        modifier = Modifier.offset(y = 40.dp),
        containerColor =  (colorResource(id = R.color.sl_dark_green)),
        contentColor = (colorResource(id = R.color.white))) {
        Icon(Icons.Filled.Add , contentDescription = "New")
    }
}
