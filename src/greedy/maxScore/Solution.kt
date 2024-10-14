package greedy.maxScore

import java.util.*
import kotlin.math.ceil

class Solution {
    fun maxKelements(nums: IntArray, k: Int): Long {
        var score = 0L
        var times = k
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        for (num in nums) {
            queue.add(num)
        }
        while (times > 0) {
            val max = queue.poll()
            score += max
            queue.add(ceil(max.toDouble() / 3).toInt())
            times--
        }
        return score
    }
}