package prefixSumBinarySearch

fun main() {
    println(Solution().chalkReplacer(intArrayOf(3, 4, 1, 2), 25))
}

class Solution {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {

        val prefix = IntArray(chalk.size)
        prefix[0] = chalk[0]
        for (i in 1 until chalk.size) {
            prefix[i] += prefix[i - 1]
        }
        val sum = prefix.last()
        val chalkLim = k % sum

        var i = upperBound(chalk, chalkLim)
        i--
        if (i < 0) i = chalk.size - 1
        return i
    }

    private fun upperBound(list: IntArray, chalkLim: Int): Int {
        var left = 0
        var right = list.size

        while (left < right) {
            val mid = (left + right) / 2
            if (list[mid] <= chalkLim) right = mid
            else left = mid + 1
        }
        return left
    }
}
