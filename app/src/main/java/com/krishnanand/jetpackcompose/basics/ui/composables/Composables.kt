package com.krishnanand.jetpackcompose.basics.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krishnanand.jetpackcompose.basics.ui.theme.JetpackComposeBasicsTheme


@Composable
fun Greeting(name: String) {
    Surface (
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentHeight()
            .padding(8.dp),
        color = MaterialTheme.colors.primary
    ) {
       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.padding(24.dp)
       ) {
           Text(text = "Hello")
           Text(text = name)
       }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp() {
    Surface(color=MaterialTheme.colors.background) {
        Greeting("Android")
    }
}