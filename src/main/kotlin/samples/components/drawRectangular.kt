package samples.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun drawSolidRectangular() {
    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        val width = size.width
        val height = size.height
        drawRect(
            color = Color.Green,
            size = Size(width, 300f),
            topLeft = Offset(0f, 100f)
        )
    }
}

@Composable
fun drawHollowRectangular() {
    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        val width = size.width
        val height = size.height
        drawRect(
            color = Color.Black,
            size = Size(width, 300f),
            topLeft = Offset(0f, 100f),
            style = Stroke(
                width = 10f
            )
        )
    }
}

@Composable
fun drawStrokeRectangular() {
    Canvas(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize()
    ) {
        val width = size.width
        val height = size.height
        drawRoundRect(
            color = Color.Blue,
            size = Size(width, 300f),
            topLeft = Offset(0f, 100f),
            cornerRadius = CornerRadius(20f),
            style = Stroke(
                width = 10f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 25f), 25f),
            ),
        )

    }
}
