package com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.*
import com.example.mobilprestamos_kotlin_v1.models.MLClientes
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId

@Composable
fun AccountCreated(navController: NavHostController, Id: String){
    loadViewsAccount(navController, Id)
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadViewsAccount(navController: NavHostController, id: String){
    val context= LocalContext.current
    var name by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono1 by remember { mutableStateOf("") }
    var telefono2 by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var ocupacion by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    var vivienda by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var provincia by remember { mutableStateOf("") }
    var municipio by remember { mutableStateOf("") }
    var sector by remember { mutableStateOf("") }
    var direccionTrabajo by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }

    var showDateDialog by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val service = ApiService.instance
    var progressIndicator = remember {
        mutableStateOf(false)
    }
    val mainViewModel: MainViewModel = viewModel()
    var id = id

    val accountmap = HashMap<String, String>()
    accountmap[MLClientes.KEY_APELLIDO] = name
    println(accountmap.get(MLClientes.KEY_APELLIDO))

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .verticalScroll(scrollState)){

        if(progressIndicator.value) {
            loaderProgress()
        }
        /// nombre ///
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(context.getString(R.string.account_name)) },
            modifier = Modifier
                .fillMaxWidth()
        )
        spaceViews(value = 8)
        /// apellido ///
        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text(context.getString(R.string.account_last_name)) },
            modifier = Modifier
                .fillMaxWidth()
        )
        spaceViews(value = 8)
        /// cedula y fecha de nacimiento ///
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){

            OutlinedTextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text(context.getString(R.string.account_cedula)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            var show by remember {
                mutableStateOf(false)
            }
            val state = rememberDatePickerState()
            var valueDate by remember {
                mutableStateOf("")
            }
            //  Column (modifier = modifer){
            if(show) {
                DatePickerDialog(
                    onDismissRequest = {
                        show = false
                    },
                    confirmButton = {
                        Button(onClick = {
                            show = false }) {
                            Text(text = LocalContext.current.getString(R.string.button_login))
                        }
                    },
                    dismissButton = {
                        OutlinedButton(onClick = {
                            show = false
                        }
                        ) {
                            Text(text = LocalContext.current.getString(R.string.button_cancel))
                        }
                    }
                ) {
                    DatePicker(state = state)
                }
            }
            val date = state.selectedDateMillis
            date?.let {
                val localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
                valueDate = " ${localDate.dayOfMonth}/${localDate.month}/${localDate.year}"

            }

            OutlinedTextField(
                value = valueDate,
                onValueChange = { valueDate = it },
                label = { Text(LocalContext.current.getString(R.string.account_fecha_naciomiento)) },
                modifier = Modifier.weight(0.5f),
                enabled = false,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            show = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CalendarMonth,
                            contentDescription = "Clear"
                        )
                    }
                }
            )
            /*
            datePicker(
                LocalContext.current.getString(R.string.account_fecha_naciomiento),
                Modifier.weight(0.5f)
            )*/
        }
        spaceViews(value = 8)
        /// Telefono y celular o Whatsapp ///
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly){

            OutlinedTextField(
                value = telefono1,
                onValueChange = { telefono1 = it },
                label = { Text(context.getString(R.string.account_telefono)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            OutlinedTextField(
                value = telefono2,
                onValueChange = { telefono2 = it },
                label = { Text(context.getString(R.string.account_celular_o_whatsapp)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)
        /// Ocupacion ///
        OutlinedTextField(
            value = ocupacion,
            onValueChange = { ocupacion = it },
            label = { Text(context.getString(R.string.account_ocupacion)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// Nacionalidad ///
        Row {
            OutlinedTextField(
                value = nacionalidad,
                onValueChange = { nacionalidad = it },
                label = { Text(context.getString(R.string.account_nacionalidad)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            /// Vivienda ///
            OutlinedTextField(
                value = vivienda,
                onValueChange = { vivienda = it },
                label = { Text(context.getString(R.string.account_vivienda)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)
        /// correo ///
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text(context.getString(R.string.account_correo)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// direccion ///
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text(context.getString(R.string.account_direccion)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)

        Row {
            /// provincia ///
            OutlinedTextField(
                value = provincia,
                onValueChange = { provincia = it },
                label = { Text(context.getString(R.string.account_provincia)) },
                modifier = Modifier.weight(0.5f)
            )
            spaceViews(value = 8)
            /// municipio ///
            OutlinedTextField(
                value = municipio,
                onValueChange = { municipio = it },
                label = { Text(context.getString(R.string.account_municipio)) },
                modifier = Modifier.weight(0.5f)
            )
        }
        spaceViews(value = 8)

        /// sector ///
        OutlinedTextField(
            value = sector,
            onValueChange = { sector = it },
            label = { Text(context.getString(R.string.account_sector)) },
            modifier = Modifier.fillMaxWidth()
        )
        spaceViews(value = 8)
        /// direccion trabajo ///
        OutlinedTextField(
            value = direccionTrabajo,
            onValueChange = { direccionTrabajo = it },
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
                progressIndicator.value = !progressIndicator.value
                if(progressIndicator.value){
                    val cliente = MLClientes(
                        apellido = apellido,
                        cedula = dni,
                        cliente = "test8",
                        correo = correo,
                        creado_por = 1,
                        direccion = direccion,
                        identificacion_garante = "",
                        ingresos = 45000,
                        lugar_trabajo =  direccionTrabajo,
                        nombre = name,
                        ocupacion = ocupacion,
                        telefono1 = telefono1,
                        telefono2 = telefono2,
                        user_log = 1,
                        id_cliente = if(mainViewModel.newAccount) "" else id
                    )
                    scope.launch {
                        try {
                            if(mainViewModel.newAccount) {
                                val values = service.add_account(cliente)
                                if (values.isSuccessful && values.body()!!.resultado.equals("Ok")) {
                                    Toast.makeText(context, "---SUCESS--- ", Toast.LENGTH_LONG)
                                        .show()
                                    navController.popBackStack()
                                } else {
                                    Toast.makeText(context, "ERROR!!!! ", Toast.LENGTH_LONG).show()
                                }
                            }else{
                                val values = service.update_Account(cliente)
                                if (values.isSuccessful && values.body()!!.resultado.equals("Ok")) {
                                    Toast.makeText(context, "---SUCESS--- ", Toast.LENGTH_LONG)
                                        .show()
                                    navController.popBackStack()
                                } else {
                                    Toast.makeText(context, "ERROR EDITANDO!!!! ", Toast.LENGTH_LONG).show()
                                }
                            }
                            progressIndicator.value = !progressIndicator.value
                        } catch (e: Exception) {
                            e.stackTrace
                        }
                    }
                }


                /* navController.navigate(
                     route = AppScreens.HomeContent.route)*/
                //Toast.makeText(context, "presionaste el boton", Toast.LENGTH_LONG).show()
            }){
            Text(text = "GUARDAR", fontSize = 15.sp)
        }
    }
}



