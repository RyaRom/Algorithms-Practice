package digitSumAfterConvert

import java.util.*

fun main() {
    Solution().getLucky("iiii",1)
}
class Solution {
    fun getLucky(s: String, k: Int): Int {
        val codes =s.toCharArray().map { it.lowercaseChar() - 'a' + 1 }
        val sumCodes: String = codes.joinToString("") { it.toString() }
        var sum = sumCodes.toCharArray().sumOf { it.digitToInt() }
        var times = k-1
        while (times > 0){
            if (sum < 9) break
            sum = sum.toString().toCharArray().sumOf { it.digitToInt() }
            times--
        }
        return sum
    }
}