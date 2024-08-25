package closestPalindrome

import kotlin.math.abs

fun main() {
    println(Solution().nearestPalindromic("9009"))
}

class Solution {
    fun nearestPalindromic(n: String): String {
        if (n == "0") return "1"
        if (n.length == 1) return (n.toInt() - 1).toString()
        if (n == "1" + "0".repeat(n.length - 1)) {
            return "9".repeat(n.length - 1)
        }

        if (n == "9".repeat(n.length)) {
            return ("1" + "0".repeat(n.length - 1) + "1")
        }
        val size = n.length
        val poly4 = "9".repeat(size - 1)
        val poly5 = "1" + "0".repeat(size - 1) + "1"
        var poly1: String
        var poly2: String
        var poly3: String
        if (size % 2 != 0) {
            val half = n.substring(0, size / 2)
            val middle = n[size / 2]
            val middleVal = middle.digitToInt()
            poly1 = half + middle + half.reversed()
            if (middleVal > 0) poly2 = half + (middle - 1) + half.reversed()
            else {
                val lowHalf = half.substring(0, half.length - 1) + ((half.last().digitToInt()) - 1)
                poly2 = lowHalf + "9" + lowHalf.reversed()
                if (((half.last().digitToInt()) - 1) < 0) poly2 = "-1"
            }
            if (middleVal < 9) poly3 = half + (middle + 1) + half.reversed()
            else {
                val bigHalf = half.substring(0, half.length - 1) + (half.last().digitToInt() + 1)
                poly3 = bigHalf + "0" + bigHalf.reversed()
                if (((half.last().digitToInt()) + 1) > 9) poly3 = "-1"
            }
        } else {
            val half = n.substring(0, size / 2 - 1)
            val middle = n[size / 2 - 1]
            val middleVal = middle.digitToInt()
            poly1 = half + middle + middle + half.reversed()
            if (middleVal > 0) {
                poly2 = half + (middle - 1) + (middle - 1) + half.reversed()
            } else {
                val lowHalf = half.substring(0, half.length - 1) + ((half.last().digitToInt()) - 1)
                poly2 = lowHalf + "9" + "9" + lowHalf.reversed()
                if (((half.last().digitToInt()) - 1) < 0) poly2 = "-1"
            }
            if (middleVal < 9) {
                poly3 = half + (middle + 1) + (middle + 1) + half.reversed()
            } else {
                val bigHalf = half.substring(0, half.length - 1) + (half.last().digitToInt() + 1)
                poly3 = bigHalf + "0" + "0" + bigHalf.reversed()
                if (((half.last().digitToInt()) + 1) > 9) poly3 = "-1"
            }
        }
        if (poly1 == n) poly1 = "-1"
        if (poly2 == n) poly2 = "-1"
        if (poly3 == n) poly3 = "-1"
        val variants = listOf(poly3, poly2, poly5, poly4, poly1).filter { it != "-1" }
            .map { a -> Pair(a, abs(a.toLong() - n.toLong())) }
        return variants.minWith(compareBy({ it.second }, { it.first.toLong() })).first
    }
}