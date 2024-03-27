package com.example.mobilprestamos_kotlin_v1.screens.modulos.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import com.example.mobilprestamos_kotlin_v1.utils.UsuarioDto
import kotlinx.coroutines.launch


@Composable
fun loadviews(navController: NavHostController){
    loadComponentViews(navController)
}

@Preview
@Composable
fun loadHeader(modifier: Modifier){
    Row ( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center){
        Text(
            LocalContext.current.getString(R.string.app_name_label),
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
    spaceViews(10)
    loadImage(modifier.size(100.dp))

}
/*
@Composable
fun spaceViews(value: Int){
    Spacer(modifier = Modifier.padding(value.dp))
}*/

@Composable
fun loadImage(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Header",
        modifier = modifier
    )
}

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadComponentViews(navController: NavHostController){
    val context= LocalContext.current
    var user by remember { mutableStateOf("freddy@20.com") }
    var pass by remember { mutableStateOf("1234") }
    val scope = rememberCoroutineScope();
    var progressIndicator = remember {
        mutableStateOf(false)
    }
    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
        /*ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.size(width = 320.dp, height = 450.dp)
        ) {*/
            if(progressIndicator.value) {
                loaderProgress(progressState = progressIndicator)
            }
            Column (modifier = Modifier.padding(10.dp)){
                spaceViews(10)
                loadHeader(Modifier.align(Alignment.CenterHorizontally))
                spaceViews(10)
                OutlinedTextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text(context.getString(R.string.Edittext_user)) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                )
                spaceViews(5)
                OutlinedTextField(
                    value = pass,
                    onValueChange = { pass = it },
                    label = { Text(context.getString(R.string.Edittext_pass)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                )

                spaceViews(30)
                ElevatedButton(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.sl_dark_green)),
                    onClick = {
                    progressIndicator.value = !progressIndicator.value
                   /* navController.navigate(
                        route = AppScreens.HomeContent.route)*/
                    //Toast.makeText(context, "presionaste el boton", Toast.LENGTH_LONG).show()
                })   {
                    if(progressIndicator.value) {
                       /* CircularProgressIndicator(
                            modifier = Modifier.padding(5.dp,0.dp),
                            color = colorResource(id = R.color.white),
                            strokeWidth = Dp(value = 4f)
                        )
                        Text(text = "Por favor espere...")*/

                        if(!user.equals("") || !pass.equals("")) {
                            val scope = rememberCoroutineScope()
                            val service = ApiService.instance
                            var isValido = false;
                            val usuario = UsuarioDto(
                                usuario = user,
                                contrasena = pass,
                                cliente =  "test8"
                            )

                            scope.launch {
                                try {
                                    val values = service.CallLogin(usuario)
                                    if(values.isSuccessful && values.body()!!.id == 2){
                                        isValido = true;
                                        navController.navigate(
                                            route = AppScreens.Content.route
                                        )
                                    } else {
                                        Toast.makeText(context, "ERROR ", Toast.LENGTH_LONG).show()
                                    }
                                    progressIndicator.value = !progressIndicator.value
                                }catch (e: Exception){
                                    e.stackTrace
                                }
                            }

                        }else{
                            Toast.makeText(context, "Usuario o contraseña vacios", Toast.LENGTH_LONG).show()
                            progressIndicator.value = !progressIndicator.value
                        }

                    }
                    Text(text = context.getString(R.string.button_login), fontSize = 20.sp)
                }
                /*
            Button(onClick = {
                Toast.makeText(context, "presionaste el boton", Toast.LENGTH_LONG).show()
            }) { Text(text = context.getString(R.string.button_cancel)) }*/
            }
        //}
    }
}

@Composable
fun loaderProgress(progressState: MutableState<Boolean>){
    Column (modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        CircularProgressIndicator(
            modifier = Modifier.padding(5.dp),
            color = colorResource(id = R.color.teal_700),
            strokeWidth = Dp(value = 4f)
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun verificacionUser(user: String, pass: String): Boolean {
    val scope = rememberCoroutineScope()
    val service = ApiService.instance
    var isValido = false;
    val usuario = UsuarioDto(
        usuario = user,
        contrasena = pass,
        cliente =  "test8"
    )

    scope.launch {
        try {
            val values = service.CallLogin(usuario)
            if(values.isSuccessful){
                isValido = true;
            }
        }catch (e: Exception){
            e.stackTrace
        }
    }
    return isValido
}
