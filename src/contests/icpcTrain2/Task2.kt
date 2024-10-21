package contests.icpcTrain2

import java.util.*

fun main() {
    val t = readln().toInt()
    repeat(t) {
        readln()
        val n = readln().split(" ").map { it.toInt() }
        val unique = mutableSetOf<Int>()
        val map = TreeMap<Int, Int>()
        for ((index, num) in n.withIndex()) {
            if (num !in unique) {
                map[num] = index
                unique.add(num)
            }else if (num in unique) {
                map.remove(num)
            }
        }
        if (map.isNotEmpty()) {
            println(map.firstEntry().value + 1)
        } else println(-1)
    }
}