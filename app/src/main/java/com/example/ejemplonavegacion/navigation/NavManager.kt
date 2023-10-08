package com.example.ejemplonavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ejemplonavegacion.views.DetailView
import com.example.ejemplonavegacion.views.HomeView

//Función para administrar por medio del NavController la navegación entre pantallas
@Composable
fun NavManager(){
    //RememberNavController maneja la pila de pantallas en las que se navega
    val navController = rememberNavController()
    //NavHost es el contenedor que conoce las rutas hacia donde navegar
    //con cada acción del navController
    NavHost(navController = navController, startDestination = "Home"){
        //Se crea la ruta para navegar a la vista de Home
        composable("Home"){
            HomeView(navController)
        }
        //Se crea la ruta para navegar a la vista detallada
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id"){ type = NavType.IntType},
            navArgument("opcional"){ type = NavType.StringType},
        )){
            //Se obtienen los argumentos enviados en la ruta
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?:""
            DetailView(navController, id, opcional)
        }
    }
}



