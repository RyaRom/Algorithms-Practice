package greedy.maxDistanceArray

import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(Solution().maxDistance(listOf(listOf(-2), listOf(-3, -2, 1))))
}

class Solution {
    fun maxDistance(arrays: List<List<Int>>): Int {
        val first = findMin(arrays, -1)
        val second = findMax(arrays, first.second)

        val third = findMax(arrays, -1)
        val fourth = findMin(arrays, third.second)

        return max(abs(first.first - second.first), abs(third.first - fourth.first))
    }

    private fun findMin(arrays: List<List<Int>>, exclude: Int): Pair<Int, Int> {
        var minV = 1000000
        var index = 0
        for (i in arrays.indices) {
            val array = arrays[i]
            if (array.first() < minV && i != exclude) {
                minV = array.first()
                index = i
            }
        }
        return Pair(minV, index)
    }

    private fun findMax(arrays: List<List<Int>>, exclude: Int): Pair<Int, Int> {
        var maxV = -1000000
        var index = 0
        for (i in arrays.indices) {
            val array = arrays[i]
            if (array.last() > maxV && i != exclude) {
                maxV = array.last()
                index = i
            }
        }
        return Pair(maxV, index)
    }
}