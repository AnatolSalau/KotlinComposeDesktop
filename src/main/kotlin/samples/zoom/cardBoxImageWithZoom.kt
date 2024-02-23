package samples.zoom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.mouse.mouseScrollFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication

@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication {
    Box(
        Modifier
            .size(200.dp)
            .background(Color.Red)
            .mouseScrollFilter { event, _ ->
                println(event.delta)
                true
            }
    )
}