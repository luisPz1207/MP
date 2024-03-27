package com.example.mobilprestamos_kotlin_v1.componentsUtils
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mobilprestamos_kotlin_v1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBackPress(navController: NavHostController, label: String){
    val context = LocalContext.current
    TopAppBar(title = { Text(text = label, fontSize = 18.sp, color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.primary_color)),
        navigationIcon = {
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(Icons.Default.ArrowBack, "Abrir menu", tint = Color.White)
        }
    })
}