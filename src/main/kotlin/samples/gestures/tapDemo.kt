package samples.gestures

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
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
fun xyDoubleTapCoordinates() {
    var xOffset by remember { mutableStateOf(0f) }
    var yOffset by remember { mutableStateOf(0f) }
    var textState by remember { mutableStateOf("Waiting ....") }

    val tapHandler = { status: String ->
        textState = status

    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    tapHandler("onPress Detected")
                    detectTapGestures { offset: Offset ->
                        xOffset = offset.x
                        yOffset = offset.y
                    }
                },
                onDoubleTap = { tapHandler("onDoubleTap Detected") },
                onLongPress = { tapHandler("onLongPress Detected") },
                //onTap = { tapHandler("onTap Detected") }
            )
        }
    ) {
        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Blue)
                .size(100.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(textState)
        Text(xOffset.toString())
        Text(yOffset.toString())
    }
}
/*

 */
@Composable
fun xyTapCoordinates() {
    var xOffset by remember { mutableStateOf(0f) }
    var yOffset by remember { mutableStateOf(0f) }
    var textState by remember { mutableStateOf("Waiting ....") }

    val tapHandler = { status: String ->
        textState = status

    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .pointerInput(Unit) {
            detectTapGestures { offset: Offset ->
                // Touch coordinates on image
                xOffset = offset.x
                yOffset = offset.y
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