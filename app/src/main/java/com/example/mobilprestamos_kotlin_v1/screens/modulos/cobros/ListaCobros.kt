package com.example.mobilprestamos_kotlin_v1.screens.modulos.cobros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.componentsUtils.BottomBarApp
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loadListCobros
import com.example.mobilprestamos_kotlin_v1.models.AppMenuNavigation
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet
import com.example.mobilprestamos_kotlin_v1.models.listCollection
import com.example.mobilprestamos_kotlin_v1.utils.Utils

@Composable
fun Cobros(navController: NavHostController, type: String){

    listaCobros(navController, TipolistaCobros(type))
}

fun TipolistaCobros(type: String): List<listCollection> {
    var list = listOf(
        listCollection.items,
        listCollection.items_4,
    )
    if(Utils.TYPE_COBROS_PENDIENTES.type.equals(type)) {
        list = listOf(
            listCollection.items,
            listCollection.items_4,
        )
    }else if(Utils.TYPE_COBROS_REALIZADOS.type.equals(type)){
        list = listOf(
            listCollection.items_2,
            listCollection.items_3,
        )
    }else if(Utils.TYPE_COBROS_VENCIDOS.type.equals(type)){
        list = listOf(
            listCollection.items_5
        )
    }
    return list
}

@Composable
fun listaCobros(navController: NavHostController, listaCobros: List<listCollection>) {
    val items = listOf(
        AppMenuNavigation.ListaCobrosPendientes,
        AppMenuNavigation.ListaCobrosRealizados,
        AppMenuNavigation.ListaCobrosVencidos,
    )
    val mainViewModel: MainViewModel = viewModel()

    val listOpciones = listOf(
        OpcionesSheet.detailCobro,
    )
    
    Scaffold (
        bottomBar = {
            BottomBarApp(navController, items)
        }
    ) {padding->
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(color = Color.White)) {
            loadListCobros(navController, listaCobros)
            /*if(mainViewModel.showBottomSheet) {
                BottomSheet(navController = navController, listOpciones)
            }*/
        }
    }
}