package integerToLexicographic

fun main() {
    println(findKthNumber(10000, 0))
}

class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        return (1..n)
            .map { it.toString() }
            .sorted()
            .map { it.toInt() }
            .toList()
    }
}

fun findKthNumber(n: Int, k: Int): Int {
    var cur = 1L
    var k: Long = (k - 1).toLong();

    while (k > 0) {
        val step = stepsBetween(n.toLong(), cur, cur + 1)
        if (step <= k) {
            cur++
            k -= step
        } else {
            cur *= 10
            k--
        }
    }
    return cur.toInt()
}

fun stepsBetween(n: Long, prefix1: Long, prefix2: Long): Long {
    var pr1 = prefix1
    var pr2 = prefix2
    var steps = 0L
    while (pr1 <= n) {
        steps += minOf(n + 1, pr2) - pr1
        pr1 *= 10
        pr2 *= 10
    }
    return steps
}

