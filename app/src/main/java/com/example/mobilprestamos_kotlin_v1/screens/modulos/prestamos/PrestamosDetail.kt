package com.example.mobilprestamos_kotlin_v1.screens.modulos.prestamos

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.datePicker
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loadSpinnerView
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.cliente0

@Composable
fun PrestamoDetail(navController: NavHostController){
    val scope = rememberCoroutineScope()
    val mainViewModel: MainViewModel = viewModel()
   // mainViewModel.getListAccounts()
    loadViewsPrestamo(navController, mainViewModel)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadViewsPrestamo(navController: NavHostController, mainViewModel: MainViewModel) {
   Box(
       modifier = Modifier
           .padding(10.dp)
           .fillMaxSize()
   ) {
       contenidoPrestamo(mainViewModel)
   }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contenidoPrestamo(mainViewModel: MainViewModel){
    val context= LocalContext.current
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var showDateDialog by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()

    val cliente = cliente0
    
    val list = mutableListOf(cliente)

    if (mainViewModel.showList) {
        list.addAll(mainViewModel.listaccounts)
    }

    val select by remember {
        mutableStateOf(list[0])
    }
    var isOpen by remember {
        mutableStateOf(false)
    }

    Column (modifier = Modifier
        .padding(20.dp)
        .verticalScroll(scrollState)){

       /* OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(context.getString(R.string.clientes)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            enabled = false,
            trailingIcon = {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.SupervisorAccount,
                        contentDescription = "Clear"
                    )
                }
            }
        )*/


        Column (
            modifier = Modifier
                .fillMaxWidth()
        ){
            ExposedDropdownMenuBox(
                expanded = isOpen,
                onExpandedChange = {isOpen = !isOpen}
            ) {
                OutlinedTextField(
                    value = select.nombre,
                    onValueChange = {select.nombre =  it},
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    readOnly = true,
                    label = { Text(text = context.getString(R.string.clientes))},
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(isOpen)}
                )
                ExposedDropdownMenu(
                    expanded = isOpen,
                    onDismissRequest = { isOpen = false}) {
                    list.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text.nombre) }, onClick = {
                                select.nombre = list[index].nombre
                                isOpen = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }

                }

            }
        }
        spaceViews(value = 10)
         OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text(context.getString(R.string.prestamo_deuda_actual)) },
             modifier = Modifier
                 .align(Alignment.CenterHorizontally)
                 .fillMaxWidth()
            )
        spaceViews(value = 10)
        datePicker(LocalContext.current.getString(R.string.prestamo_fecha_desembolo), Modifier.fillMaxWidth())
        spaceViews(value = 10)
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(context.getString(R.string.prestamo_monto)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        spaceViews(value = 10)
        loadSpinnerView(LocalContext.current.getString(R.string.prestamo_periodo))

        spaceViews(value = 10)
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(context.getString(R.string.prestamo_interes)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )

        spaceViews(value = 10)
        loadSpinnerView(LocalContext.current.getString(R.string.prestamo_plazo))
        spaceViews(value = 10)
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(context.getString(R.string.prestamo_referencia)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        spaceViews(value = 10)
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(context.getString(R.string.prestamo_detalle)) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )

        spaceViews(value = 10)
        ElevatedButton(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.sl_dark_green)),
            onClick = {

                /* navController.navigate(
                     route = AppScreens.HomeContent.route)*/
                //Toast.makeText(context, "presionaste el boton", Toast.LENGTH_LONG).show()
            }){
            Text(text = "GUARDAR", fontSize = 15.sp)
        }

    }
}

val clientes = listOf(
    "chanquito",
    "chimuelo",
    "coco",
    "reina",
    "maria",
    "panlo",
    "tairon",
)

