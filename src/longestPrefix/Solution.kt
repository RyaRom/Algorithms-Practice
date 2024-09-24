package longestPrefix

fun main() {
    println(Solution().longestCommonPrefix(intArrayOf(102, 1004, 567), intArrayOf(1003, 565, 12)))
}

class Solution {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val prefixes = HashSet<String>()
        fillPrefixes(arr1, prefixes)
        return findBiggestPrefix(arr2, prefixes)
    }

    private fun fillPrefixes(arr: IntArray, prefixes: HashSet<String>) {
        for (num in arr) {
            val str = num.toString()
            for (i in str.length downTo 1) {
                if (!prefixes.add(str.substring(0, i))) break
            }
        }
    }

    private fun findBiggestPrefix(arr: IntArray, prefixes: HashSet<String>): Int {
        var max = 0
        for (num in arr) {
            val str = num.toString()
            for (i in str.length downTo 1) {
                if (str.substring(0, i) in prefixes) {
                    max = maxOf(max, i)
                    break
                }
            }
        }
        return max
    }
}


