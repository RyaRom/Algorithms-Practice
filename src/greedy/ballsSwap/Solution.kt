package greedy.ballsSwap

class Solution {
    fun minimumSteps(s: String): Long {
        val balls = s.toCharArray()
        var leftPtr = 0
        var swaps = 0L
        for (i in balls.indices) {
            if (balls[i] == '0') {
                swaps += i - leftPtr
                leftPtr++
            }
        }
        return swaps
    }
}