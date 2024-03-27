package com.example.mobilprestamos_kotlin_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.mobilprestamos_kotlin_v1.navigations.RootNavigation
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import com.example.mobilprestamos_kotlin_v1.utils.UsuarioDto
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = ApiService.instance
        var id = false
        val usuario = UsuarioDto(
            usuario = "freddy@20.com",
            contrasena = "1234",
            cliente =  "test8"
        )

        lifecycleScope.launch {
            try {
                val values = service.CallLogin(usuario)
            }catch (e: Exception){
                e.stackTrace
            }
        }
        setContent {
            val navController = rememberNavController()
            RootNavigation(navController)
           // AppNavigation(navController)
        }
    }
}

@Composable
fun loaddataReturn(){
    Text(
        text = "sucess",
        style = MaterialTheme.typography.titleMedium
    )
}

