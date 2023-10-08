package com.example.ejemplonavegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ejemplonavegacion.components.MainButton
import com.example.ejemplonavegacion.components.MainIconButton
import com.example.ejemplonavegacion.components.Space
import com.example.ejemplonavegacion.components.TitleBar
import com.example.ejemplonavegacion.components.TitleView

//Función para organizar los elementos que conforman nuestra pantalla
//Recibe como argumento el navController el cual servirá para navegar
//de una pantalla a otra con un click de botón
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?){
    Scaffold(
        topBar = {
                TopAppBar(
                    title = { TitleBar(name = "Detail View") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.Blue
                    ),
                    navigationIcon = {
                        //El botón en la barra de navegación permite navegar hacia atrás
                        //en la pila de vistas visitadas
                        MainIconButton(icon = Icons.Default.ArrowBack) {
                            navController.popBackStack()
                        }
                    }
                )
        }
    ) {
        //Nuestra función que nos provee los componentes a nuestra vista
        ContentDetailView(navController, id, opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleBar(name = "Detail View")
        Space()
        //Asignamos el valor de la variable id que viene de la pantalla Home
        TitleView(name = id.toString())
        Space()
        //Asignamos el valor obtendio de la pantalla home a un campo de texto
        //llamado TitleView creado en BodyComponent.kt
        if (opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty())
        }
        MainButton(name = "Return home", backColor = Color.Blue, color = Color.White) {
            //La función del boton permite navegar hacia la pantalla anterior, en este caso Home
            navController.popBackStack()
        }
    }
}