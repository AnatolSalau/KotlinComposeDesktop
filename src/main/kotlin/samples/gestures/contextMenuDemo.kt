package samples.gestures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.mouseClickable
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
//@OptIn(ExperimentalFoundationApi::class)
fun drawContextMenu() {
    var xOffset by remember { mutableStateOf(0f) }
    var yOffset by remember { mutableStateOf(0f) }
    var textState by remember { mutableStateOf("Waiting ....") }
    var expanded by remember { mutableStateOf(false) }

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
                .fillMaxSize()
                .mouseClickable {
                    if (buttons.isSecondaryPressed) {
                        expanded = true
                    }
                }
        )
// tmp fix for https://github.com/JetBrains/compose-jb/issues/2012
        var renderCount by remember { mutableStateOf(0) }
        listOf(renderCount, renderCount - 1).forEach { renderId ->
            val isActive = renderId == renderCount
            key(renderId) {
                CursorDropdownMenu(
                    expanded = expanded && isActive,
                    onDismissRequest = {
                        if (isActive) {
                            renderCount += 1
                            expanded = false
                        }
                    },
                ) {
                    DropdownMenuItem({}) {
                        Text("First item")
                    }
                    DropdownMenuItem({}) {
                        Text("Second item")
                    }
                }
            }
        }
    }
}