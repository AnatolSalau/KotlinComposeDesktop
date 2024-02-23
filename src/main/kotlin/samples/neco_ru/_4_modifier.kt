package samples.neco_ru

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun drawCardWithModifier(name: String, prof: String) {
    var defaultText by remember { mutableStateOf("Переключить график") }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .background(color = Color.LightGray)
                .pointerInput(Unit) {
                    detectDragGesturesAfterLongPress  { change, dragAmount ->
                        run {
                            defaultText = dragAmount.toString();
                        }
                    }
                }

        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .pointerInput(Unit) {
                    },
                elevation = 5.dp,
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                    }
                }
            }
            Spacer(Modifier.size(5.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = 5.dp
            ) {
                Box(
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(
                            painter = painterResource("erythrocytes.png"),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.CenterStart,
                            modifier = Modifier.height(40.dp).padding(5.dp)
                        )
                        Column{
                            Text(text = name)
                            Text(text = prof)
                        }
                    }
                }
            }
            Text(text = defaultText)
        }
    }
}