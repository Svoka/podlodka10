package ru.sverstal.podlodka10.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sverstal.podlodka10.ui.theme.*

@Composable
fun Alpha() {

    var enabled by remember { mutableStateOf(false) }
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0f)

    Column {
        Box(
            modifier = Modifier
                .alpha(alpha)
                .size(200.dp)
                .background(Purple200)
        )

        Box(
            modifier = Modifier
                .graphicsLayer {
                    this.alpha = alpha
                }
                .size(200.dp)
                .background(Teal200)
        )
        Button(onClick = {
            enabled = !enabled
        }) {
            Text("Change state")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    Podlodka10Theme {
        Alpha()
    }
}