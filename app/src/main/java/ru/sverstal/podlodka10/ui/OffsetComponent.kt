package ru.sverstal.podlodka10.ui

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import ru.sverstal.podlodka10.ui.theme.*

@Composable
fun OffsetComponent() {

    var enabled by remember { mutableStateOf(false) }
    val offset: Int by animateIntAsState(if (enabled) 200 else 0)

    Column {
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = offset.dp)
                .size(200.dp)
                .background(Purple200)
        )
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(0, offset)
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
        OffsetComponent()
    }
}