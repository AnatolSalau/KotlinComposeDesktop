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

const val MIN_ZOOM_SIZE: Float = 50f

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun drawRectangularByDragMouse() {
    var xTap by remember { mutableStateOf(0f) }
    var yTap by remember { mutableStateOf(0f) }
    var tapCoordinates by remember { mutableStateOf("Tap coordinates") }

    var xDragStart by remember { mutableStateOf(0f) }
    var yDragStart by remember { mutableStateOf(0f) }
    var xyDragStartCoordinates by remember { mutableStateOf("Drag start coordinates") }

    var xDragEnd by remember { mutableStateOf(0f) }
    var yDragEnd by remember { mutableStateOf(0f) }
    var dragAmountCoordinates by remember { mutableStateOf("Drag end coordinates") }

    val interactionSource = remember { MutableInteractionSource() }
    val coroutineScope = rememberCoroutineScope()
    var dragType by remember { mutableStateOf("-") }

    var zoomXLeft by remember { mutableStateOf(0f) }
    var zoomYLeft by remember { mutableStateOf(0f) }
    var zoomWidth by remember { mutableStateOf(0f) }
    var zoomHeight by remember { mutableStateOf(0f) }
    var zoomColorULong: ULong by remember { mutableStateOf(Color.Transparent.value) }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
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
                zoomColorULong = Color.Transparent.value
            }
        }
        .pointerInput(Unit) {
            var interaction: DragInteraction.Start? = null

            detectDragGestures(
                onDragStart = { offset ->
                    run {
                        xTap = offset.x
                        yTap = offset.y

                        zoomXLeft = offset.x
                        zoomYLeft = offset.y
                        zoomColorULong = Color.Transparent.value

                    }
                    coroutineScope.launch {
                        interaction = DragInteraction.Start()
                        interaction?.run {
                            interactionSource.emit(this)
                        }

                    }
                },
                onDrag = { change: PointerInputChange, dragAmount: Offset ->
                    run {
                        xTap += dragAmount.x
                        yTap += dragAmount.y

                        fun calculateCoordinates(
                            dragCoordinate: Float,
                            tapCoordinate: Float,
                            minValue: Float
                        ): Float {
                            val size = -(dragCoordinate - tapCoordinate)

                            if (size.absoluteValue != dragCoordinate && size.absoluteValue != tapCoordinate && size.absoluteValue > minValue) {
                                return size
                            } else {
                                return 0f
                            }
                        }

                        zoomWidth = calculateCoordinates(xDragStart, xTap, MIN_ZOOM_SIZE)
                        zoomHeight = calculateCoordinates(yDragStart, yTap, MIN_ZOOM_SIZE)

                        if ((zoomWidth.absoluteValue > MIN_ZOOM_SIZE) && (zoomHeight.absoluteValue > MIN_ZOOM_SIZE)) {
                            zoomColorULong = Color.Green.value
                        } else {
                            zoomColorULong = Color.Transparent.value
                        }

                    }
                },
                onDragCancel = {
                    zoomWidth = 0f
                    zoomHeight = 0f
                    zoomColorULong = Color.Transparent.value
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
        Canvas(
            modifier = Modifier
        ) {
            drawRoundRect(
                color = Color(zoomColorULong),
                size = Size(
                    width = zoomWidth,
                    height = zoomHeight
                ),
                topLeft = Offset(
                    zoomXLeft,
                    zoomYLeft
                ),
                cornerRadius = CornerRadius(10f),
                style = Stroke(
                    width = 4f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 20f), 5f),
                ),
            )
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
        Text("Drag status : $dragType")

        Spacer(Modifier.height(10.dp))
        Text("Zoom width : ${zoomWidth.absoluteValue}")
        Text("Zoom height : ${zoomHeight.absoluteValue}")
        Text("Zoom color : ${if (zoomColorULong == Color.Transparent.value) "Transparent" else "Green"}")

        Spacer(Modifier.height(10.dp))

    }
}

class TempZoom(val zoomWidth: Float, val zoomHeight: Float, val zoomColorULong: ULong);