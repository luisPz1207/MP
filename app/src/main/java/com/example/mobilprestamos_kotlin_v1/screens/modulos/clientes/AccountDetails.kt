package com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews

@Composable
fun DetailsAccount(){
    loadViewsDetails()
}

@Composable
fun loadViewsDetails(){
    val context = LocalContext.current
    val masInfo = remember {
        mutableStateOf(false)
    }
    val masInfoAdress = remember {
        mutableStateOf(false)
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(120, 0, LinearEasing)
                    )
                    .background(colorResource(id = R.color.white))
                    .clickable {
                        //mainViewModel.showBottomSheet = true
                        //navController.navigate(route = AppScreens.PrestamosDetail.route)
                    }
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                    Text(
                        text = "Datos Personales",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f),
                        fontSize = 20.sp
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
                if (masInfo.value) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Name",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(1f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = "cedula",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)){


                        Text(
                            text = "Fecha nacimiento",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = "Telefono",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)){
                        Text(
                            text = "Celular/Whatsapp",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = "Ocupacion",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)){
                        Text(
                            text = "Nacionalida",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_vivienda),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_correo),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }


                }
            }
        }
        spaceViews(value = 10)

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(120, 0, LinearEasing)
                    )
                    .background(colorResource(id = R.color.white))
                    .clickable {
                        //mainViewModel.showBottomSheet = true
                        //navController.navigate(route = AppScreens.PrestamosDetail.route)
                    }
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Direcciones", fontSize = 20.sp,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = {
                        masInfoAdress.value = !masInfoAdress.value
                    }) {
                        Icon(
                            if (masInfoAdress.value) Icons.Default.Remove
                            else Icons.Default.Add, contentDescription = "mas información direcciones"
                        )
                    }
                }

                if(masInfoAdress.value){

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_provincia),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_municipio),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_sector),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_direccion),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top=5.dp)) {
                        Text(
                            text = context.getString(R.string.account_direccion_trabajo),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.weight(0.5f),
                            fontSize = 15.sp
                        )
                    }

                }




            }
        }
    }

}