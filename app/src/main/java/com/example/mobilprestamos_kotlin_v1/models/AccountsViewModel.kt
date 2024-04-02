package com.example.mobilprestamos_kotlin_v1.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilprestamos_kotlin_v1.utils.ApiService
import com.example.mobilprestamos_kotlin_v1.utils.Delete_Account
import com.example.mobilprestamos_kotlin_v1.utils.Globals
import kotlinx.coroutines.launch

class AccountsViewModel: ViewModel()  {
    var showList by mutableStateOf(false)
    private val list_Accounts = MutableLiveData<List<Accounts>>()
    val _list_Accounts: LiveData<List<Accounts>> = list_Accounts

    var ERROR: String by mutableStateOf("")
    var accountID by mutableStateOf("")
    var newAccount by mutableStateOf(false)

    init {
        val service = ApiService.instance
        viewModelScope.launch {
            try{
                val list = service.getListAccounts()
                list_Accounts.value = list
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
                list_Accounts.value = list
                showList = true
            }catch (e: Exception){
                e.stackTrace
                ERROR = e.message.toString()
            }
        }
    }

    fun filtrarClientes(filtro: String){
        if(!filtro.isEmpty() && !filtro.equals("")){
            val clientes = list_Accounts.value?.filter{it.nombre.contains(filtro, ignoreCase = true)}
            list_Accounts.value = clientes!!
            showList = true
        }else{
            getListAccounts()
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