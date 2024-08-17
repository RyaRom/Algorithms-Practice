package dynamicArrayScore

import kotlin.math.abs
import kotlin.math.max
fun main(){
    println(Solution().maxPoints(arrayOf(intArrayOf(1,2,3), intArrayOf(1,5,1), intArrayOf(3,1,1))))
}
class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val dp = Array(points.size) { i -> LongArray(points[i].size) { 0 } }
        dp[0] = points[0].map { it.toLong() }.toLongArray()
        for (i in 1 until points.size) {
            for (j in points[i].indices) {
                var maxVal:Long = 0
                for (k in points[i-1].indices) {
                    maxVal = max(maxVal, dp[i-1][k] - abs(j-k))
                }
                dp[i][j] = points[i][j] + maxVal
            }
        }
        return dp.last().max()
    }
}