package com.example.ejemplonavegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ejemplonavegacion.components.ActionButton
import com.example.ejemplonavegacion.components.MainButton
import com.example.ejemplonavegacion.components.Space
import com.example.ejemplonavegacion.components.TitleBar
import com.example.ejemplonavegacion.components.TitleView

//Función que genera los elementos necesarios para crear una pantalla
//También recibe como argumento un NavController el cual administra la
//navegación entre pantallas
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    //Scaffold es un componente que provee una estructura para agrupar varios componentes
    //material y construir la pantalla
    Scaffold(
        //Agrega una barra de navegación en la parte superior de la pantalla
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View" )},
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ){
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController){
    //Declaramos dos variables las cuales enviaremos de una vista a otra
    val id = 123
    var opcional by remember { mutableStateOf("")}
    //Organizamos los componentes en columnas
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name = "Home View")
        Space()
        //Campo de texto para capturar datos por medio del teclado
        TextField(
            value = opcional,
            onValueChange = {opcional = it},
            label = { Text(text = "Opcional")}
        )
        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
            //Acción para navegar de esta pantalla hacia la pantalla de detalles,
            //Enviando los valores de id y opcional
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}