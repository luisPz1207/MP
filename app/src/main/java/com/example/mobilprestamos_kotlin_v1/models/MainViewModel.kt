package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import com.example.mobilprestamos_kotlin_v1.utils.Delete_Account
import com.example.mobilprestamos_kotlin_v1.utils.Globals
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    var showBottomSheet by mutableStateOf(false)
    var showLoaderProgress by mutableStateOf(false)

    /// TODO viewmodel para clientes ///
    var showList by mutableStateOf(false)
    val list_Accounts: List<Accounts> = mutableListOf()
    var listaccounts: List<Accounts> by mutableStateOf(listOf())

    var ERROR: String by mutableStateOf("")
    var accountID by mutableStateOf("")
    var newAccount by mutableStateOf(false)

    init {
        val service = ApiService.instance
        viewModelScope.launch {
            try{
                val list = service.getListAccounts()
                listaccounts = list
                showList = true
            }catch (e: Exception){
                e.stackTrace
                ERROR = e.message.toString()
            }
        }
    }
    fun getListAccounts(){
        val service = ApiService.instance
        viewModelScope.launch {
            try{
                val list = service.getListAccounts()
                listaccounts = list
                showList = true
            }catch (e: Exception){
                e.stackTrace
                ERROR = e.message.toString()
            }
        }
    }


    fun DeleteAccounts(accountid: String){
        val account = Delete_Account(
            accountid,
            Globals.USER_LOG,
            Globals.DB_TEST
        )
        val service = ApiService.instance
        viewModelScope.launch {
            try{
                val result = service.delete_Account(account)
                if (result.isSuccessful && result.body()!!.resultado.equals("Ok")){
                    getListAccounts()
                }else{

                }
            }catch (e: Exception){
                e.stackTrace
                ERROR = e.message.toString()
            }
        }
    }
}
