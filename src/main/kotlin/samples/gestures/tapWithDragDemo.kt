package samples.gestures

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun xyTapWithDragCoordinates() {
    var xOffset by remember { mutableStateOf(0f) }
    var yOffset by remember { mutableStateOf(0f) }
    var textState by remember { mutableStateOf("Waiting ....") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .pointerInput(Unit) {
            detectTapGestures { offset: Offset ->
                // Touch coordinates on image
                xOffset = offset.x
                yOffset = offset.y;

            }
        }
    ) {
        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Blue)
                .size(10.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(textState)
        Text(xOffset.toString())
        Text(yOffset.toString())
    }
}