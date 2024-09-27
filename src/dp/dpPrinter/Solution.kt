package dp.dpPrinter

import kotlin.math.min

fun main() {
    println(Solution().strangePrinter("tbgtgb"))
}

class Solution {
    fun strangePrinter(s: String): Int {
        val text = ArrayList<Byte>();
        var cur = s.toCharArray()[0]
        text.add(cur.code.toByte())
        for (c in s.toCharArray()) {
            if (c != cur) {
                cur = c
                text.add(cur.code.toByte())
            }
        }
        val dp = Array(text.size) { _ -> IntArray(text.size) { 100000 } }
        return spliterator(text, 0, text.size - 1, dp)
    }

    private fun spliterator(text: List<Byte>, start: Int, end: Int, dp: Array<IntArray>): Int {
        if (start > end) return 0
        if (dp[start][end] != 100000) return dp[start][end]
        var parts = 1 + spliterator(text, start + 1, end, dp)
        for (i in start + 1..end) {
            if (text[i] == text[start]) {
                parts = min(spliterator(text, start, i - 1, dp) + spliterator(text, i + 1, end, dp), parts)
            }
        }
        dp[start][end] = parts
        return parts
    }
}
