package samples.components

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun drawRectangularByDragMouse() {
    var xTap by remember { mutableStateOf(  0f) }
    var yTap by remember { mutableStateOf(0f) }
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

    var zoomXLeft by remember { mutableStateOf(0f) }
    var zoomYLeft by remember { mutableStateOf(0f) }
    var zoomWidth by remember { mutableStateOf(0f) }
    var zoomHeight by remember { mutableStateOf(0f) }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect {
                interaction ->
            run {
                when (interaction) {
                    is DragInteraction.Start -> {
                        dragType = "start"
                        xDragStart = xTap
                        yDragStart = yTap
                    }
                    is DragInteraction.Stop -> {
                        dragType = "stop"
                        xDragEnd = xTap
                        yDragEnd = yTap
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
                xTap = offset.x
                yTap = offset.y;

                zoomXLeft = 0f
                zoomYLeft = 0f
                zoomWidth = 0f
                zoomHeight = 0f
            }
        }
        .pointerInput(Unit) {
            var interaction: DragInteraction.Start? = null

            detectDragGestures(
                onDragStart = { offset -> run {
                    xTap = offset.x
                    yTap = offset.y
                }
                    coroutineScope.launch {
                        interaction = DragInteraction.Start()
                        interaction?.run {
                            interactionSource.emit(this)
                        }

                    }
                    zoomXLeft = offset.x
                    zoomYLeft = offset.y
                },
                onDrag = { change: PointerInputChange, dragAmount: Offset ->
                    xTap += dragAmount.x
                    yTap += dragAmount.y

                    zoomWidth = -(xDragStart - xTap)
                    zoomHeight = -(yDragStart - yTap)
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

        if (zoomWidth.absoluteValue > 25 && zoomHeight.absoluteValue > 25) {
            Canvas(
                modifier = Modifier
            ) {

                drawRoundRect(
                    color = Color.Green,
                    size = Size(
                        width = zoomWidth,
                        height = zoomHeight
                    ),
                    topLeft = Offset(
                        zoomXLeft,
                        zoomYLeft),
                    cornerRadius = CornerRadius(10f),
                    style = Stroke(
                        width = 4f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 20f), 5f),
                    ),
                )

            }
        }

        Box(
            Modifier
                .offset { IntOffset(xTap.roundToInt(), yTap.roundToInt()) }
                .background(Color.Blue)
                .size(10.dp)
        )

        Spacer(Modifier.height(10.dp))
        Text(tapCoordinates)
        Text(xTap.toString())
        Text(yTap.toString())

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

