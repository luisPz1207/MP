package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    var showBottomSheet by mutableStateOf(false)
}
