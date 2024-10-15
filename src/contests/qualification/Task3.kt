package contests.qualification

import java.util.*

fun main() {
    val t = readln().toInt()
    val queue = PriorityQueue<Pair<Int, Int>>(Comparator.comparingInt { it.first })
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        queue.add(Pair(a, b))
    }

    while (queue.isNotEmpty()){

    }
}