package ru.sverstal.podlodka10.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sverstal.podlodka10.ui.theme.Podlodka10Theme

@Composable
fun Greeting(name: String) {
    Column() {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            val padInPx = with(LocalDensity.current) {
                4.dp.toPx()
            }

            Text(text = "Hello $name", )
            Text("10",  modifier = Modifier
                .padding(start = 4.dp)
                .drawBehind {
                    drawRoundRect(
                        color = Color(0xFFBAA0E9),
                        topLeft = Offset(-padInPx, -padInPx / 4f),
                        cornerRadius = CornerRadius(this.size.width),
                        size = this.size.copy(
                            width = this.size.width + padInPx * 2,
                            height = this.size.height + padInPx
                        )
                    )
                })
        }
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Hello $name")
            Text("10",
                modifier = Modifier
                    .background(
                        color = Color(0xFFBAA0E9),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(4.dp))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DefaultPreview() {
    Podlodka10Theme {
        Greeting(name = "Podlodka")
    }
}