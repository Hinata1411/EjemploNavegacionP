package com.example.ejemplonavegacion.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Función para crear espacios de un mismo tamaño
@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

//Función para crear textos a los títulos de cada vista
//Con las mismas propiedades
@Composable
fun TitleView(name: String){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

//Función que proporciona un botón para cada una de las vistas
//El parámetro onClick de clase Unit sirve para enviar funciones que se asignan al botón
//estas son de acción al hacer click
@Composable
fun MainButton(name:String, backColor: Color, color: Color, onClick:() -> Unit){
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor
    )) {
        Text(text = name)
    }
}