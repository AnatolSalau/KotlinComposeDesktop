package samples.neco_ru

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*


@Composable
fun addButton() {
    var text by remember { mutableStateOf("Переключить график") }
    MaterialTheme {
        Button(onClick = {
            text = "График переключен"
        }) {
            Text(text)
        }
    }
}

