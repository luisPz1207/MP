package com.example.mobilprestamos_kotlin_v1.screens.modulos.login

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.spaceViews
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import com.example.mobilprestamos_kotlin_v1.utils.ShareSheet
import com.example.mobilprestamos_kotlin_v1.utils.UsuarioDto
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch
import java.io.File



private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34

private fun foregroundPermissionApproved(context: Context): Boolean {
    val writePermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val readPermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.READ_EXTERNAL_STORAGE
    )

    return writePermissionFlag && readPermissionFlag
}

private fun requestForegroundPermission(context: Context) {
    val provideRationale = foregroundPermissionApproved(context = context)
    if (provideRationale) {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )
    } else {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE
        )
    }
}

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun permisions(context: Context){
    val permissionsState = rememberMultiplePermissionsState(permissions =
        listOf(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
    )
    if(permissionsState.allPermissionsGranted){
        Toast.makeText(context, "Permisos aceptados", Toast.LENGTH_LONG).show()
    }else if(permissionsState.shouldShowRationale){
        Toast.makeText(context, "Estos permisos son para almacenar loa PDF creados de los cobros", Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, "permisos denegados", Toast.LENGTH_LONG).show()
    }

    LaunchedEffect(true) {
        permissionsState.launchMultiplePermissionRequest()
    }
}

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

fun sharePdf(context: Context, fileUri: Uri) {
    // Creamos un intent para compartir el archivo PDF
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_STREAM, fileUri)
        type = "application/pdf"
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    // Iniciamos el ShareSheet
    context.startActivity(Intent.createChooser(shareIntent, "Compartir PDF"))
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun loadComponentViews(navController: NavHostController){
    val context= LocalContext.current
    permisions(context)
    var user by remember { mutableStateOf("freddy@209.com") }
    var pass by remember { mutableStateOf("12345") }
    val scope = rememberCoroutineScope();
    var progressIndicator = remember {
        mutableStateOf(false)
    }
///////// TODO COMPARTIR (SHARESHEET) ///////
    val textShare = "https://medium.com/@jpmtech/jetpack-compose-add-a-share-button-to-your-app-5f26b7554e94"
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, textShare)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
//////////////////////////////////////////////////

    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
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
               onClick = {navController.navigate(
                   route = AppScreens.Content.route

               )
             //  progressIndicator.value = !progressIndicator.value
           })   {
               /*if(progressIndicator.value) {
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

               }*/
               Text(text = context.getString(R.string.button_login), fontSize = 20.sp)
           }

       ElevatedButton(onClick = {
          // GeneratePDF(context, getDirectory())
         //  ContextCompat.startActivity(context, shareIntent, null)
           sharePdf(context, getDirectoryPDF().toUri())
       }) { Text(text = context.getString(R.string.button_cancel)) }

       }

    }
}

private fun getDirectory(): File {
    val file: File = File(Environment.getExternalStorageDirectory(), "Pdf")
    return file
}

private fun getDirectoryPDF(): File {
    val file: File = File(Environment.getExternalStorageDirectory(), "Pdf/sample.pdf")
    return file
}

@Composable
fun share(url: String){
    ShareSheet(url)
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
