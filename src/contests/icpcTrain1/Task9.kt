package contests.icpcTrain1

import kotlin.math.abs

fun main() {
    val s = readln().toInt()
    for (i in 0 until 1001) {
        for (j in 0 until 1001) {
            if (squareArea(0, i, j, 0) == s) {
                println("0 $i")
                println("$j 0")
                println("$i ${i + j}")
                println("${i + j} $j")
                return
            }
        }
    }
    println("Impossible")
}

fun squareArea(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return abs(x1 - x2) * abs(x1 - x2) + abs(y1 - y2) * abs(y1 - y2)
}