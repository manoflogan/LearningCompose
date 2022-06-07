package com.krishnanand.jetpackcompose.basics.ui.composables


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krishnanand.jetpackcompose.basics.ui.theme.JetpackComposeBasicsTheme


@Composable
fun Greeting(name: String) {
    var isExpanded by remember { mutableStateOf(false) }
    val addExtraPadding = if (isExpanded) {
         48.dp
    } else {
        0.dp
    }
    Surface (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp),
        color = MaterialTheme.colors.primary
    ) {
        Row(modifier= Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
           Column(modifier = Modifier
               .weight(1f)
               .padding(addExtraPadding)) {
                Text(text = "Hello")
                Text(text = name)
            }
            OutlinedButton(onClick = {
                    isExpanded = !isExpanded
                }
            ) {
                    Text(text = if (isExpanded) "Show Less" else "Show More")
            }
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
@Preview
fun MyApp(names: List<String> = listOf("Android", "Compose")) {
    var onboarding by remember { mutableStateOf(true) }
    if (onboarding) {
        OnboardingScreen {
            onboarding = false
        }
    } else {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name)
            }
        }
    }
}


@Composable
fun OnboardingScreen(onClick: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics codelab")
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onClick
            ) {
                Text("Continue")
            }
        }
    }
}