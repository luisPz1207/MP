package com.example.mobilprestamos_kotlin_v1.componentsUtils

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mobilprestamos_kotlin_v1.R
import com.example.mobilprestamos_kotlin_v1.models.ListAccounts
import com.example.mobilprestamos_kotlin_v1.models.ListLoans
import com.example.mobilprestamos_kotlin_v1.models.MainViewModel
import com.example.mobilprestamos_kotlin_v1.models.OpcionesSheet
import com.example.mobilprestamos_kotlin_v1.models.listCollection
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loadSpinnerView(label: String){
    val list = listOf("12","13","20","100")
    var select by remember {
        mutableStateOf(list[0])
    }
    var isOpen by remember {
        mutableStateOf(false)
    }
    
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        ExposedDropdownMenuBox(
            expanded = isOpen, 
            onExpandedChange = {isOpen = !isOpen}
        ) {
            OutlinedTextField(
                value = select, 
                onValueChange = {select =  it},
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                readOnly = true,
                label = { Text(text = label)},
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(isOpen)}
            )
            ExposedDropdownMenu(
                expanded = isOpen, 
                onDismissRequest = { isOpen = false}) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) }, onClick = {
                            select = list[index]
                            isOpen = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
                
            }
            
        }
    }
}


@Composable
fun spaceViews(value: Int){
    Spacer(modifier = Modifier.padding(value.dp))
}

@Preview
@Composable
fun AlertDialog(
    title: String,
    mensage: String,
    state: Boolean,
    onDimiss: ()->Unit,
    onConfirm: ()->Unit
) {
    val navController = rememberNavController()
    if(state) {
        AlertDialog(onDismissRequest = { onDimiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDimiss() }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text(text = title) },
            text = { Text(text = mensage) }
        )
    }
}

@Composable
fun CustomDialogTextField(
    title: String,
    mensage: String,
    state: Boolean,
    onDimiss: ()->Unit,
    onConfirm: ()->Unit
) {
    var value by remember {
        mutableStateOf("")
    }
    if(state) {
        Dialog(onDismissRequest = { onDimiss() },
           properties = DialogProperties(
               dismissOnBackPress = false,
               dismissOnClickOutside = false
           )
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Color.White, RoundedCornerShape(16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally) {
                spaceViews(value = 20)
                Text(text = title, fontSize = 20.sp, fontFamily = FontFamily.Monospace)
                spaceViews(value = 10)
                OutlinedTextField(value = value, onValueChange = {value= it})
                spaceViews(value = 10)
                Row (modifier = Modifier.align(Alignment.End).padding(end= 10.dp)){
                    ElevatedButton(onClick = { onDimiss()},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
                        Text(text = "Cancelar", color = colorResource(id = R.color.sl_dark_green))
                    }
                    spaceViews(value = 10)
                    ElevatedButton(onClick = { onConfirm() },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.sl_dark_green))) {
                        Text(text = "Guardar")
                    }
                }
            }
        }
    }
}

//// CLIENTES ////
@Composable
fun loadList(navController: NavHostController, list: List<ListAccounts>){
    val listAccounts = list
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(listAccounts){item->
            rows(item, navController)
        }
    }
}


@Composable
fun rows(item: ListAccounts, navController: NavHostController){
    val masInfo = remember {
        mutableStateOf(false)
    }
    val mainViewModel: MainViewModel = viewModel()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = tween(120, 0, LinearEasing)
            )
            .background(colorResource(id = R.color.white))
            .clickable {
                mainViewModel.showBottomSheet = true
            }
            .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.address,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }

            if (masInfo.value) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.amount,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
    spaceViews(value = 3)

}


/// COBROS ///
@Composable
fun loadListCobros(navController: NavHostController, list: List<listCollection>){
    val listColl = list
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(listColl){item->
            rowsCobros(item, navController)
        }
    }
}


@Composable
fun rowsCobros(item: listCollection, navController: NavHostController){
    val masInfo = remember {
        mutableStateOf(false)
    }
    val mainViewModel: MainViewModel = viewModel()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(120, 0, LinearEasing)
                )
                .background(colorResource(id = R.color.white))
                .clickable {
                    // mainViewModel.showBottomSheet = true

                }
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.address,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }

            if (masInfo.value) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.amount,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
    spaceViews(value = 3)

}



/// PRESTAMOS ///
@Composable
fun loadListPrestamos(navController: NavHostController, list: List<ListLoans>){
    val listColl = list
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(listColl){item->
            rowsPrestamos(item, navController)
            Divider()
        }
    }
}


@Composable
fun rowsPrestamos(item: ListLoans, navController: NavHostController){
    val masInfo = remember {
        mutableStateOf(false)
    }
    val mainViewModel: MainViewModel = viewModel()
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(120, 0, LinearEasing)
                )
                .background(colorResource(id = R.color.white))
                .clickable {
                    mainViewModel.showBottomSheet = true
                    //navController.navigate(route = AppScreens.PrestamosDetail.route)
                }
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if(item.activo) LocalContext.current.getString(R.string.prestamo_sin_atraso)
                    else LocalContext.current.getString(R.string.prestamo_con_atraso),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }

            if (masInfo.value) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = item.amount,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = item.cuotasPagadas+"/"+item.cuotasPendientes,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
    spaceViews(value = 3)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(navController: NavHostController, listItem: List<OpcionesSheet>){
    val mainViewModel: MainViewModel = viewModel()
    ModalBottomSheet(onDismissRequest = {
        mainViewModel.showBottomSheet = false }
    ) {
        contentBottomSheet(navController,listItem)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun contentBottomSheet(navController: NavHostController, listItem: List<OpcionesSheet>){
    val items = listItem
    val scope = rememberCoroutineScope()
    val stateSheet = rememberModalBottomSheetState()
    val mainViewModel: MainViewModel = viewModel()
    Column (modifier = Modifier
        .fillMaxWidth()
        .height(280.dp)
        .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Opciones", fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp))
        items.forEach {item ->
            Row (verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .clickable {
                                scope
                                    .launch {
                                        stateSheet.hide()
                                    }
                                    .invokeOnCompletion {
                                        mainViewModel.showBottomSheet = false
                                    }
                                navController.navigate(item.ruta)
                            }
            ){
                Icon( item.icon, contentDescription ="")
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = item.label)
            }
        }
    }
}