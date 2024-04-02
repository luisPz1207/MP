package com.example.mobilprestamos_kotlin_v1.navigations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mobilprestamos_kotlin_v1.models.AppScreens
import com.example.mobilprestamos_kotlin_v1.screens.DetailContent
import com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes.AccountCreated
import com.example.mobilprestamos_kotlin_v1.screens.modulos.clientes.DetailsAccount


fun NavGraphBuilder.DetailNavigation(navController: NavHostController){
    navigation(route = Graph.DETAILS,
        startDestination = AppScreens.PrestamosDetail.route,
    ) {
        composable(route = AppScreens.PrestamosDetail.route){
            DetailContent(navController, AppScreens.PrestamosDetail.route)
        }

        composable(route = AppScreens.ClientesDetalle.route){
            DetailsAccount()
        }
        /*
        composable(route = "${AppScreens.ClientesDetalle.route}{account}"){ backStackEntry ->
            val account = backStackEntry.arguments?.getParcelable<MLClientes>("account")
            requireNotNull(account)
            DetailsAccount(/*account*/)
        }*/

        composable(route = "${AppScreens.CrearCliente.route}{id}"){backStackEntry ->
            val Id = backStackEntry.arguments?.getString("id")
            requireNotNull(Id)
            AccountCreated(navController, Id)
        }

    }
}
/*
inline fun <reified T, Parcelable> parcelableTypeOf() = object : NavType<T>(isNullableAllowed = true)
{
    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): T? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): T {
       return Json.decodeFromString(Uri.decode(value))
    }



}
*/

/*
@Composable
fun DetailNavigationApp(navController: NavHostController){
    NavHost(navController = navController,
        route = Graph.DETAILS,
        startDestination = AppScreens.PrestamosDetail.route,
    ) {
        composable(route = AppScreens.PrestamosDetail.route){
            PrestamoDetail(navController)
        }
        composable(route = AppScreens.ClientesDetalle.route){
            DetailsAccount()
        }
        composable(route = AppScreens.CrearCliente.route){
            AccountCreated(navController)
        }
    }
}*/
