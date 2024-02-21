package samples.neco_ru

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap

import androidx.compose.ui.unit.dp
import java.io.File
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
@Preview
fun listItem(name: String, prof: String) {
    MaterialTheme {
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(

            ) {
                Image(painter = painterResource("erythrocytes.png"),
                    contentDescription = "image",
                    imageModifier,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
val imageModifier = Modifier
    .height(240.dp)
    .fillMaxWidth()
    .clip(RoundedCornerShape(12.dp))

