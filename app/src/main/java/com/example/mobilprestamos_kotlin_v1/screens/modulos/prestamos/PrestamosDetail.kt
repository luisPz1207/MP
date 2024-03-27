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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.datePicker
import com.example.mobilprestamos_kotlin_v1.componentsUtils.loadSpinnerView
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews

@Composable
fun PrestamoDetail(navController: NavHostController){
    loadViewsPrestamo(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadViewsPrestamo(navController: NavHostController){
    Box(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()){
        contenidoPrestamo()
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contenidoPrestamo(){
    val context= LocalContext.current
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var showDateDialog by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .verticalScroll(scrollState)){

        OutlinedTextField(
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
        )
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