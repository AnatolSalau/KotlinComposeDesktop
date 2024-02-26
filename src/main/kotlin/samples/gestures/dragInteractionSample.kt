package samples.gestures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class,
    ExperimentalMaterialApi::class,
    InternalCoroutinesApi::class)
@Composable
fun dragInteractionSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {

            val interactionSource = remember { MutableInteractionSource() }
            val interactions = remember { mutableStateListOf<Interaction>() }
            var text by remember { mutableStateOf("") }

            LaunchedEffect(interactionSource) {
                interactionSource.interactions.collect {
                        interaction ->
                    run {
                        when (interaction) {
                            is DragInteraction.Start -> {
                                text = "Drag Start"
                            }
                            is DragInteraction.Stop -> {
                                text = "Drag Stop"
                            }
                            is DragInteraction.Cancel -> {
                                text = "Drag Cancel"
                            }
                        }
                    }
                }
            }

            val coroutineScope = rememberCoroutineScope()

            var offsetX by remember { mutableStateOf(0f) }
            var offsetY by remember { mutableStateOf(0f) }

            val modifier = Modifier
                .offset {
                    IntOffset(
                        x = offsetX.roundToInt(),
                        y = offsetY.roundToInt()
                    )
                }
                .size(60.dp)
                .pointerInput(Unit) {

                    var interaction: DragInteraction.Start? = null
                    detectDragGestures(
                        onDragStart = {
                            coroutineScope.launch {
                                interaction = DragInteraction.Start()
                                interaction?.run {
                                    interactionSource.emit(this)
                                }

                            }
                        },
                        onDrag = { change: PointerInputChange, dragAmount: Offset ->
                            offsetX += dragAmount.x
                            offsetY += dragAmount.y

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

            Surface(
                modifier = modifier,
                interactionSource = interactionSource,
                onClick = {},
                content = {},
                color = MaterialTheme.colors.primary
            )

            Text(text = text)
        }
    )
}