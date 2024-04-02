package com.example.mobilprestamos_kotlin_v1.utils


import com.example.mobilprestamos_kotlin_v1.models.Accounts
import com.example.mobilprestamos_kotlin_v1.models.MLClientes
import com.example.mobilprestamos_kotlin_v1.models.UserRequestDto
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    companion object{
        val instance = Retrofit.Builder().baseUrl("http://137.184.88.96:3000/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).client(
                OkHttpClient.Builder().build()
            )
            .build().create(ApiService::class.java)
    }


    ///TODO CARGAR LISTADO DE USUARIOS ///
    @GET("list_usuarios/test8")
    suspend fun getUsers()

    ///TODO VALIDAR QUE EL USUARIO EXISTE ///
  //  @Headers("ContentType:application/json", "Accept:*/*")
    @POST("login/")
    suspend fun CallLogin(@Body userRquest: UsuarioDto):retrofit2.Response<UserRequestDto>

    ///TODO CARGAR LISTADO DE CLIENTES ///
    @GET("list_clientes/test8")
    suspend fun getListAccounts(): List<Accounts>

    /// TODO CARGAR DETALLE DE CLIENTES ///
    @GET("find_clientes")
    suspend fun getListAccountsDetails(): List<Accounts>

    ///TODO ENVIAR DATOS DE CLIENTE PARA CREAR UNO NUEVO ///
    @POST("add_cliente")
    suspend fun add_account(@Body accountRquest: MLClientes): retrofit2.Response<ResultResponse>

    ///TODO ACTUALIZAR CLIENTES ///
    @PUT("update_cliente")
    suspend fun update_Account(@Body accountRequest: MLClientes):retrofit2.Response<ResultResponse>


    ///TODO ELIMINAR CLIENTE ///
   // @DELETE("delete_cliente")
    @HTTP(method = "DELETE", path = "delete_cliente", hasBody = true)
    suspend fun delete_Account(@Body accountRequest: Delete_Account): retrofit2.Response<ResultResponse>

}

data class UsuarioDto(
    @SerializedName("usuario")
    val usuario: String,
    @SerializedName("contrasena")
    val contrasena: String,
    @SerializedName("cliente")
    val cliente: String)

data class ResultResponse(
    @SerializedName("resultado")
    val resultado: String
)

data class Delete_Account(
    @SerializedName("id_cliente")
    val id_cliente: String,
    @SerializedName("user_log")
    val user_log: String,
    @SerializedName("cliente")
    val cliente: String
)
