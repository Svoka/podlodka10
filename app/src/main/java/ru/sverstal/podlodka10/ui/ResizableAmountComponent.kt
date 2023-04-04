package ru.sverstal.podlodka10.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.sverstal.podlodka10.ui.theme.Podlodka10Theme

private const val ResizeStep = 0.97

@Composable
internal fun ResizeableAmountComponent(
    amount: String
) {
    val isInPreview = LocalInspectionMode.current

    val style = MaterialTheme.typography.h1

    var textStyle by remember {
        mutableStateOf(style)
    }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        text = amount,
        style = textStyle,
        color = Color.Black,
        maxLines = 1,
        overflow = TextOverflow.Visible,
        modifier = Modifier.drawWithContent {
            if (readyToDraw) {
                drawContent()
            }
        },
        onTextLayout = { textLayoutResult ->
            if (!readyToDraw && textLayoutResult.didOverflowWidth) {
                textStyle = textStyle.copy(
                    fontSize = textStyle.fontSize * ResizeStep
                )
            } else {
                readyToDraw = true
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    Podlodka10Theme {
        ResizeableAmountComponent(amount = "1234567890")
    }
}