package com.krishnanand.jetpackcompose.basics.ui.composables


import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krishnanand.jetpackcompose.basics.R
import com.krishnanand.jetpackcompose.basics.ui.theme.JetpackComposeBasicsTheme


@Composable
fun Greeting(names: List<String>) {
    Surface (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(names) { name ->
                // To save the example after scrolling and not being visblle
                var isExpanded by rememberSaveable { mutableStateOf(false) }
                val addExtraPadding by animateDpAsState(
                    if (isExpanded) {
                        48.dp
                    } else {
                        0.dp
                    },
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                Surface(modifier = Modifier.padding(4.dp),
                    color = MaterialTheme.colors.primary) {
                    Row(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(bottom = addExtraPadding.coerceAtLeast(0.dp))
                        ) {
                            Text(text = "Hello")
                            Text(text = name, style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.Bold)
                            )
                            val density = LocalDensity.current
                            AnimatedVisibility(visible = isExpanded,
                               /* enter = slideInVertically {
                                    with(density) { 10.dp.roundToPx() }
                                },
                                exit = slideOutVertically {
                                    with(density) {
                                        -10.dp.roundToPx()
                                    }
                                }*/
                            ) {
                                Text(text = stringResource(R.string.loren_ipsum))
                            }
                        }
                        IconButton(onClick = {
                            isExpanded = !isExpanded
                        }) {
                            Icon(
                                imageVector = if (isExpanded) {
                                    Icons.Filled.ExpandLess
                                } else {
                                    Icons.Filled.ExpandMore
                                },
                                contentDescription = stringResource(if (isExpanded) {
                                        R.string.show_less
                                    } else {
                                        R.string.show_more
                                    }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicsTheme {
        Greeting(listOf("Android"))
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
fun MyApp(names: List<String> = List(100) {
    it.toString()
}) {
    var onboarding by rememberSaveable { mutableStateOf(true) }
    if (onboarding) {
        OnboardingScreen {
            onboarding = false
        }
    } else {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            Greeting(names)
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