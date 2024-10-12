package contests.icpcTrain1

import kotlin.math.ceil

fun main() {
    val (symbols, w, h, flushesToBurn) = readln().split(" ").map { it.toInt() }
    var maxSymbol = ' '
    var maxPixelsPerLine = 0
    repeat(symbols) {
        val current = readln()[0]
        repeat(h) {
            var currentCount = 0
            val line = ".${readln()}."
            for (i in 1 until line.length) {
                if (line[i] != line[i - 1]) {
                    currentCount++
                }
            }
            if (currentCount > maxPixelsPerLine) {
                maxPixelsPerLine = currentCount
                maxSymbol = current
            }
        }
    }
    val repeatTimes = ceil(flushesToBurn.toDouble() / maxPixelsPerLine).toInt()
    println(maxSymbol.toString().repeat(repeatTimes))
}