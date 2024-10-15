package contests.icpcTrain1

import kotlin.math.sqrt

fun main() {
    val (days, strength) = readln().split(" ").map { it.toDouble() }
    val prices = readln().split(" ").map { it.toInt() }
    val diffs = IntArray(prices.size)
    for (i in 1 until prices.size) {
        diffs[i] = prices[i] - prices[i - 1]
    }

    var positive = 0
    var negative = 0
    for (i in prices.indices) {
        for (j in i + 2 until prices.size) {
            val avg = countAvg(diffs, i, j)
            if (avg == 0.0) continue
            val dev = countDeviation(diffs, i, j, avg)
            if (dev == 0.0) {
                if (avg > 0) positive++
                else negative++
                continue
            }
            val coefficient = avg / dev
            if (coefficient >= strength) {
                positive++
            } else if (coefficient <= -strength) {
                negative++
            }
        }
    }

    println("$positive $negative")
}

fun countAvg(diffs: IntArray, start: Int, end: Int): Double {
    var sum = 0.0
    for (i in start + 1..end) {
        sum += diffs[i]
    }
    return sum / (end - start)
}

fun countDeviation(diffs: IntArray, start: Int, end: Int, avg: Double): Double {
    var variance = 0.0
    for (i in start + 1..end) {
        val diff = diffs[i] - avg
        variance += diff * diff
    }
    return sqrt(variance / (end - start))
}
