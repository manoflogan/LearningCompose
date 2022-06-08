package com.krishnanand.jetpackcompose.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.krishnanand.jetpackcompose.basics.ui.composables.MyApp
import com.krishnanand.jetpackcompose.basics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
               MyApp()
            }
        }
    }
}