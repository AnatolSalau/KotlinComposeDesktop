package samples.charts

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

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

/**
 * Represents a group of Transactions
 * @param maxTransaction the max transaction value in the list of transactions previously calculated in some repository.
 * @param transactions list of transactions per second.
 */
data class TransactionsPerSecond(
    val maxTransaction: Double,
    val transactions: List<TransactionRate>
)

/**
 * Represents a transaction rate.
 * @param timeStamp the time stamp of the transaction.
 * @param transactionsPerSecondValue the quantity of transactions made per second.
 */
data class TransactionRate(
    val timeStamp: Long,
    val transactionsPerSecondValue: Double
)

@Composable
@Preview
fun drawLinearTransactionsChart(
    modifier: Modifier = Modifier,
    transactionsPerSecond: TransactionsPerSecond
) {
    if (transactionsPerSecond.transactions.isEmpty()) return

    Canvas(modifier = modifier) {
        // Total number of transactions.
        val totalRecords = transactionsPerSecond.transactions.size

        // Maximum distance between dots (transactions)
        val lineDistance = size.width / (totalRecords + 1)

        // Canvas height
        val cHeight = size.height

        // Add some kind of a "Padding" for the initial point where the line starts.
        var currentLineDistance = 0F + lineDistance

        transactionsPerSecond.transactions.forEachIndexed { index, transactionRate ->
            if (totalRecords >= index + 2) {
                drawLine(
                    start = Offset(
                        x = currentLineDistance,
                        y = calculateYCoordinate(
                            higherTransactionRateValue = transactionsPerSecond.maxTransaction,
                            currentTransactionRate = transactionRate.transactionsPerSecondValue,
                            canvasHeight = cHeight
                        )
                    ),
                    end = Offset(
                        x = currentLineDistance + lineDistance,
                        y = calculateYCoordinate(
                            higherTransactionRateValue = transactionsPerSecond.maxTransaction,
                            currentTransactionRate = transactionsPerSecond.transactions[index + 1].transactionsPerSecondValue,
                            canvasHeight = cHeight
                        )
                    ),
                    color = Color(40, 193, 218),
                    strokeWidth = Stroke.DefaultMiter
                )
            }
            currentLineDistance = currentLineDistance + lineDistance
        }
    }
}

/**
 * Calculates the Y pixel coordinate for a given transaction rate.
 *
 * @param higherTransactionRateValue the highest rate value in the whole list of transactions.
 * @param currentTransactionRate the current transaction RATE while iterating the list of transactions.
 * @param canvasHeight the canvas HEIGHT for draw the linear chart.
 *
 * @return [Float] Y coordinate for a transaction rate.
 */
private fun calculateYCoordinate(
    higherTransactionRateValue: Double,
    currentTransactionRate: Double,
    canvasHeight: Float
): Float {
    val maxAndCurrentValueDifference = (higherTransactionRateValue - currentTransactionRate)
        .toFloat()
    val relativePercentageOfScreen = (canvasHeight / higherTransactionRateValue)
        .toFloat()
    return maxAndCurrentValueDifference * relativePercentageOfScreen
}