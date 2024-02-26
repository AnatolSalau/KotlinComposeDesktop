package samples.gestures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun xyTapWithDragCoordinates() {
    var xOffset by remember { mutableStateOf(  0f) }
    var yOffset by remember { mutableStateOf(0f) }
    var tapCoordinates by remember { mutableStateOf("Tap coordinates") }

    var xDragStart by  remember { mutableStateOf(0f) }
    var yDragStart by  remember { mutableStateOf(0f) }
    var xyDragStartCoordinates by remember { mutableStateOf("Drag start coordinates") }

    var xDragEnd by  remember { mutableStateOf(0f) }
    var yDragEnd by  remember { mutableStateOf(0f) }
    var dragAmountCoordinates by remember { mutableStateOf("Drag end coordinates") }

    val interactionSource = remember { MutableInteractionSource() }
    val coroutineScope = rememberCoroutineScope()
    var dragType by remember { mutableStateOf("Drag type") }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
                interaction ->
            run {
                when (interaction) {
                    is DragInteraction.Start -> {
                        dragType = "start"
                        xDragStart = xOffset
                        yDragStart = yOffset
                    }
                    is DragInteraction.Stop -> {
                        dragType = "stop"
                        xDragEnd = xOffset
                        yDragEnd = yOffset
                    }
                    is DragInteraction.Cancel -> {
                        dragType = "cancel"
                    }

                }
            }
        }
    }

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
        .pointerInput(Unit) {
            var interaction: DragInteraction.Start? = null
            detectDragGestures(
                onDragStart = { offset -> run {
                    xOffset = offset.x
                    yOffset = offset.y
                }
                    coroutineScope.launch {
                        interaction = DragInteraction.Start()
                        interaction?.run {
                            interactionSource.emit(this)
                        }

                    }
                },
                onDrag = { change: PointerInputChange, dragAmount: Offset ->
                    xOffset += dragAmount.x
                    yOffset += dragAmount.y
                },
                onDragCancel = {
                    coroutineScope.launch {
                        interaction?.run {
                            interactionSource.emit(DragInteraction.Cancel(this))
                        }
                    }
                },
                onDragEnd = {
                    coroutineScope.launch {
                        interaction?.run {
                            interactionSource.emit(DragInteraction.Stop(this))
                        }
                    }
                }
            )
        }
    ) {
        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Blue)
                .size(10.dp)
        )

        Spacer(Modifier.height(10.dp))
        Text(tapCoordinates)
        Text(xOffset.toString())
        Text(yOffset.toString())

        Spacer(Modifier.height(10.dp))
        Text(xyDragStartCoordinates)
        Text(xDragStart.toString())
        Text(yDragStart.toString())

        Spacer(Modifier.height(10.dp))
        Text(dragAmountCoordinates)
        Text(xDragEnd.toString())
        Text(yDragEnd.toString())

        Spacer(Modifier.height(10.dp))
        Text(dragType)
    }
}

