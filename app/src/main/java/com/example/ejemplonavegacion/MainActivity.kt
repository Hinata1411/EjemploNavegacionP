package com.example.ejemplonavegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ejemplonavegacion.navigation.NavManager
import com.example.ejemplonavegacion.ui.theme.EjemploNavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjemploNavegacionTheme {
                setContent{
                    NavManager()
                }
            }
        }
    }
}

