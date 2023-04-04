package ru.sverstal.podlodka10.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sverstal.podlodka10.ui.theme.Podlodka10Theme
import ru.sverstal.podlodka10.ui.theme.Purple200

@Composable
fun ShadowComponent() {

    val shadowElevation =  10.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(30.dp)
    ) {
        Box(modifier = Modifier
            .graphicsLayer {
                alpha = 0.9f
                this.shadowElevation = shadowElevation.toPx()
                ambientShadowColor = Color.Red
                spotShadowColor = Color.Red
            }
//            .shadow(
//                elevation = shadowElevation,
//                ambientColor = Color.Red,
//                spotColor = Color.Red
//            )
            .background(Purple200)
            .size(100.dp)
        )
    }


}


@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    Podlodka10Theme {
        ShadowComponent()
    }
}