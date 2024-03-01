// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import delfihealth.startApp
import samples.charts.drawLineChart
import samples.components.drawHollowRectangular
import samples.components.drawRectangularByDragMouse
import samples.components.drawSolidRectangular
import samples.components.drawStrokeRectangular


@Composable
@Preview
fun app() {
    //drawCardWithModifier(name = "name", prof = "surname")
    //listItem(name = "name", prof = "surname")
    //xOffsetDragDemo();
    //xyPointerInputDrag()
    //xyTapWithDragCoordinates()
    //drawContextMenu()
    //xyTapCoordinates()
    //xyTapWithDragCoordinates()
    //dragInteractionSample()
    //drawSolidRectangular()
    //drawHollowRectangular()
    //drawStrokeRectangular()
    //drawRectangularByDragMouse()
    startApp()
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}




