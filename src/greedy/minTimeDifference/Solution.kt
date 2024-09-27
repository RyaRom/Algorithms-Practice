package greedy.minTimeDifference

fun main() {
    println(Solution().findMinDifference(listOf("00:00", "23:59", "00:00")))
}

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val minutes = timePoints.map { it.split(":").let { it[0].toInt() * 60 + it[1].toInt() } }.sorted()
        var minDiff = minOf(minutes.last() - minutes.first(), 24 * 60 - minutes.last() + minutes.first())
        for (i in 0 until minutes.size - 1) {
            minDiff = minOf(minDiff, minOf(minutes[i + 1] - minutes[i], 24 * 60 - minutes[i + 1] + minutes[i]))
        }
        return minDiff
    }
}