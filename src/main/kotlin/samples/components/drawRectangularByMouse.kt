package samples.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

const val MIN_ZOOM_SIZE: Float = 20f

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
    var zoomColorULong: ULong by remember { mutableStateOf(Color.Green.value) }

    var zoomButtonText by remember { mutableStateOf("Увеличить") }

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
    MaterialTheme {
        Box(modifier = Modifier
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

                    xDragStart = 0f
                    yDragStart = 0f
                    xDragEnd = 0f
                    yDragEnd = 0f

                    zoomButtonText = "Увеличить"

                }
            }
            .pointerInput(Unit) {
                var interaction: DragInteraction.Start? = null

                detectDragGestures(
                    onDragStart = { offset ->
                        run {
                            xTap = offset.x
                            yTap = offset.y

                            xDragStart = offset.x
                            yDragStart = offset.x
                            xDragEnd = 0f
                            yDragEnd = 0f

                            zoomButtonText = "Увеличить"

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
                            zoomXLeft = xTap
                            zoomYLeft = yTap

                            fun calculateCoordinates(
                                dragCoordinate: Float,
                                tapCoordinate: Float
                            ): Float {
                                val size = dragCoordinate - tapCoordinate

                                if (abs(dragCoordinate.absoluteValue - tapCoordinate.absoluteValue) <= MIN_ZOOM_SIZE) return 0f


                                return size
                            }

                            var width = calculateCoordinates(xDragStart, xTap)
                            var height = calculateCoordinates(yDragStart, yTap)

                            if (width.absoluteValue < MIN_ZOOM_SIZE || height.absoluteValue < MIN_ZOOM_SIZE) {
                                zoomWidth = 0f
                                zoomHeight = 0f
                            } else {
                                zoomWidth = width
                                zoomHeight = height
                            }

                        }
                    },
                    onDragCancel = {

                        xDragEnd = xTap
                        yDragEnd = xTap

                        coroutineScope.launch {
                            interaction?.run {
                                interactionSource.emit(DragInteraction.Cancel(this))
                            }
                        }
                    },
                    onDragEnd = {
                        xDragEnd = xTap
                        yDragEnd = xTap

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
                modifier = Modifier.zIndex(1f)
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

            Canvas(
                modifier = Modifier
                    .offset { IntOffset(xTap.roundToInt(), yTap.roundToInt()) }
            ) {
                drawCircle(
                    color = Color.Blue,
                    radius = 5f
                )
            }

            Canvas(
                modifier = Modifier
                    .offset { IntOffset(xDragStart.roundToInt(), yDragStart.roundToInt()) }
            ) {
                drawCircle(
                    color = Color.Red,
                    radius = 5f
                )
            }
            if (xDragEnd != 0f && yDragStart != 0f && dragType == "stop"
                && zoomWidth.absoluteValue > MIN_ZOOM_SIZE
                && zoomHeight.absoluteValue > MIN_ZOOM_SIZE
            ) {
                Button(
                    onClick = {
                        zoomButtonText = "Увеличен"
                    },
                    modifier = Modifier
                        .offset { IntOffset(xDragEnd.roundToInt(), yDragEnd.roundToInt()) }
                ) {
                    Text(zoomButtonText)
                }
            }
            Row(modifier = Modifier.fillMaxSize()) {
                Column {
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
                Column(modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "The is wll be picture")
                    Image(
                        painter = painterResource("erythrocytes.png"),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.CenterStart,
                        modifier = Modifier.height(40.dp).padding(5.dp)
                    )
                }
            }
        }

    }

}

class TempZoom(val zoomWidth: Float, val zoomHeight: Float, val zoomColorULong: ULong);