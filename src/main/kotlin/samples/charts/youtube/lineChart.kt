package samples.charts.youtube

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.roundToInt

val DEFAULT_DATA = listOf(Pair(1, 1.0), Pair(1, 2.0), Pair(2, 2.0), Pair(2, 3.0))

@Composable
fun lineChart(data: List<Pair<Int, Double>> = DEFAULT_DATA) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 5.dp, color = Color.Blue
            )
    ) {
        val spacing = 100f
        val graphColor = Color.Cyan
        val transparentColor by remember { mutableStateOf(graphColor.copy(alpha = 0.5f)) }

        val upperValue by remember { mutableStateOf(data.maxOfOrNull { it.second }?.plus(1)?.roundToInt()) }
        val lowerValue by remember { mutableStateOf(data.minOfOrNull { it.second }?.toInt() ?: 0) }

        val density = LocalDensity.current

        val textpaint = remember(density) {
            Paint().apply {
                color = Color.White

            }
        }
    }

}