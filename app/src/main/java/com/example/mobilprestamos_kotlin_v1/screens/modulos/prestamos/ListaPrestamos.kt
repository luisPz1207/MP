package com.example.mobilprestamos_kotlin_v1.screens.modulos.prestamos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.BottomBarApp
import com.example.mobilprestamos_kotlin_v1.componentsUtils.BottomSheet
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loadListPrestamos
import com.example.mobilprestamos_kotlin_v1.models.AppMenuNavigation
import com.example.mobilprestamos_kotlin_v1.models.ListLoans
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet.*
import com.example.mobilprestamos_kotlin_v1.screens.DetailActivity
import com.example.mobilprestamos_kotlin_v1.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun loadListaPrestamos(navController: NavHostController, type: String){
    loadsCont(navController, TipolistaCobros(type))
}


fun TipolistaCobros(type: String): List<ListLoans> {
    var list = listOf(
        ListLoans.items,
        ListLoans.items_2,
        ListLoans.items_3,
        ListLoans.items_4,
    )
    if(Utils.TYPE_PRESTAMOS_PENDIENTES.type.equals(type)) {
        list = listOf(
            ListLoans.items,
            ListLoans.items_2,
            ListLoans.items_3,
            ListLoans.items_4,
        )
    }else if(Utils.TYPE_PRESTAMOS_REALIZADOS.type.equals(type)){
        list = listOf(
            ListLoans.items_2,

        )
    }else if(Utils.TYPE_PRESTAMOS_VENCIDOS.type.equals(type)){
        list = listOf(
            ListLoans.items_4,
        )
    }
    return list
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun loadsCont(navController: NavHostController, list: List<ListLoans>) {
    val label = LocalContext.current.getString(R.string.prestamos)
    val items = listOf(
        AppMenuNavigation.ListaPrestamosPendientes,
        AppMenuNavigation.ListaPrestamosRealizados,
        AppMenuNavigation.ListaPrestamosVencidos
    )
    val scope = rememberCoroutineScope()
    val mainViewModel: MainViewModel = viewModel()
    val listOpciones = listOf(
        detailPrestamo,
        Edit,
        cobrar,
        verRecibo
    )

    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    Scaffold(
        /*  topBar = {
            TopBarBackPress(navController = navController, label)
        },*/
        floatingActionButton = { Fab(scope, navController) },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            BottomBarApp(navController, items)
        },
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text(LocalContext.current.getString(R.string.clientes)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Clear"
                            )
                        }
                    }
                )

                loadListPrestamos(navController, list)
            }
            if (mainViewModel.showBottomSheet) {
                BottomSheet(navController = navController, listOpciones)
            }

        }
}

}

@Composable
fun Fab(scope: CoroutineScope, navController: NavHostController){
    val context = LocalContext.current.applicationContext
    FloatingActionButton(onClick = {
        scope.launch {
           /// navController.navigate(AppScreens.PrestamosDetail.route)
            val intent = Intent(context, DetailActivity::class.java )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent)
                     }
    },
        shape = CircleShape,
        modifier = Modifier.offset(y = 40.dp),
        containerColor =  (colorResource(id = R.color.sl_dark_green)),
        contentColor = (colorResource(id = R.color.white))) {
        Icon(Icons.Filled.Add , contentDescription = "New")
    }
}