// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import samples.charts.TransactionRate
import samples.charts.TransactionsPerSecond
import samples.charts.drawLineChart
import samples.charts.drawLinearTransactionsChart
import samples.neco_ru.addColumn
import samples.neco_ru.addRow
import samples.neco_ru.listItem
import samples.zoom.listItemWithZoom

@Composable
@Preview
fun app() {
    listItemWithZoom("Name", "Prof");
    //drawLineChart()
    //addRow()
    //addColumn()

    val transactionRateList: List<TransactionRate> = listOf(
        TransactionRate(5,8.0),
        TransactionRate(3,4.0),
        TransactionRate(6,9.0),
        TransactionRate(1,4.0),
        TransactionRate(3,4.0),
        TransactionRate(3,5.0)
    )
    val transactionsPerSecond: TransactionsPerSecond = TransactionsPerSecond(10.0, transactionRateList)
    //drawLinearTransactionsChart(modifier = Modifier.fillMaxSize(), transactionsPerSecond )
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        app()
    }
}




