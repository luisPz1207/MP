package com.example.mobilprestamos_kotlin_v1.componentsUtils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mobilprestamos_kotlin_v1.R
import java.time.Instant
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun datePicker(label: String, modifer: Modifier){
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
                label = { Text(label) },
                modifier = modifer,
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
      //  }
}