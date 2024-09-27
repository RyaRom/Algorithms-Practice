package dp.stoneGame2

import kotlin.math.max

class Solution {
    fun stoneGameII(piles: IntArray): Int {
        val dp = Array(piles.size + 1) { _ -> IntArray(piles.size + 1) }
        val suffixSum = IntArray(piles.size + 1)
        for (i in piles.size - 1 downTo 0) {
            suffixSum[i] = suffixSum[i + 1] + piles[i]
        }
        for (i in 0..piles.size) {
            dp[i][piles.size] = suffixSum[i]
        }
        for (i in piles.size - 1 downTo 0) {
            for (m in piles.size - 1 downTo 1) {
                var x = 1
                while (x <= 2 * m && i + x <= piles.size) {
                    dp[i][m] = max(dp[i][m], suffixSum[i] - dp[i + x][max(m, x)])
                    x++
                }
            }
        }
        return dp[0][1]
    }
}