package com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.datePicker
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews

@Composable
fun AccountCreated(navController: NavHostController){
    loadViewsAccount(navController)
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadViewsAccount(navController: NavHostController){
    val context= LocalContext.current
    var name by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var showDateDialog by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()
    Column (modifier = Modifier.fillMaxSize()
        .padding(10.dp)
        .verticalScroll(scrollState)){

        /// nombre ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_name)) },
            modifier = Modifier
                .fillMaxWidth()
        )
        spaceViews(value = 8)
        /// apellido ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_last_name)) },
            modifier = Modifier
                .fillMaxWidth()
        )
        spaceViews(value = 8)
        /// cedula y fecha de nacimiento ///
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){

            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_cedula)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            datePicker(
                LocalContext.current.getString(R.string.account_fecha_naciomiento),
                Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)
        /// Telefono y celular o Whatsapp ///
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){

            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_telefono)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_celular_o_whatsapp)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)
        /// Ocupacion ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_ocupacion)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// Nacionalidad ///
        Row {
            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_nacionalidad)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            /// Vivienda ///
            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_vivienda)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)
        /// correo ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_correo)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// direccion ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_direccion)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)

        Row {
            /// provincia ///
            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_provincia)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            /// municipio ///
            OutlinedTextField(
                value = name,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_municipio)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)

        /// sector ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_sector)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// direccion trabajo ///
        OutlinedTextField(
            value = name,
            onValueChange = { dni = it },
            label = { Text(context.getString(R.string.account_direccion_trabajo)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// guardar ///
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
