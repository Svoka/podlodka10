package ru.sverstal.podlodka10.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sverstal.podlodka10.R
import ru.sverstal.podlodka10.ui.theme.Podlodka10Theme

@Composable
fun PhotosWithFilterComponent(blendMode: BlendMode) {
    Image(painter = painterResource(R.drawable.podlodka),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .drawWithCache {
                val path = Path()
                path.addOval(
                    Rect(
                        topLeft = Offset.Zero,
                        bottomRight = Offset(size.width, size.height)
                    )
                )
                onDrawWithContent {
                    clipPath(path) {
                        this@onDrawWithContent.drawContent()
                    }
                    drawCircle(
                        Color.Red,
                        blendMode = blendMode
                    )
                }
            }
    )

}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Podlodka10Theme {
        FlowRow(
            maxItemsInEachRow = 3
        ) {

            PhotosWithFilterComponent(BlendMode.Plus)
            PhotosWithFilterComponent(BlendMode.Modulate)
            PhotosWithFilterComponent(BlendMode.Screen)
            PhotosWithFilterComponent(BlendMode.Overlay)
            PhotosWithFilterComponent(BlendMode.Darken)

            PhotosWithFilterComponent(BlendMode.Lighten)

            //Since API 29
            PhotosWithFilterComponent(BlendMode.ColorDodge)
            PhotosWithFilterComponent(BlendMode.ColorBurn)

            PhotosWithFilterComponent(BlendMode.Softlight)

            PhotosWithFilterComponent(BlendMode.Multiply)
        }

    }
}