package samples.neco_ru

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


    @Composable
    @Preview
    fun addRow() {
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 2.dp, Color.Black
                    )
                )
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text("Left")
            Text("Middle")
            Text("Right")
        }
    }

    @Composable
    @Preview
    fun addColumn() {
        Column(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 2.dp, Color.Black
                    )
                )
                .fillMaxSize(0.8f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("Top")
            Text("Middle")
            Text("Bottom")
        }
    }
