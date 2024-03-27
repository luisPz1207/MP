package com.example.mobilprestamos_kotlin_v1.utils


import com.example.mobilprestamos_kotlin_v1.models.UserRequestDto
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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

    @GET("list_usuarios/test8")
    suspend fun getUsers()

  //  @Headers("ContentType:application/json", "Accept:*/*")
    @POST("login/")
    suspend fun CallLogin(@Body userRquest: UsuarioDto):retrofit2.Response<UserRequestDto>

}

data class UsuarioDto(
    @SerializedName("usuario")
    val usuario: String,
    @SerializedName("contrasena")
    val contrasena: String,
    @SerializedName("cliente")
    val cliente: String)
