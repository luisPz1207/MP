package com.example.mobilprestamos_kotlin_v1.screens.modulos.caja

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.componentsUtils.CustomDialogTextField

@Composable
fun Caja(){
    var show by rememberSaveable {
        mutableStateOf(true)
    }
    CustomDialogTextField(title = LocalContext.current.getString(R.string.dialog_caja_title),
        mensage = "Esto e sun dialogo",
        state = show,
        {show = false},
        {})
}