package greedy.sortByFrequency

fun main() {
    println(Solution().frequencySort(intArrayOf(2, 3, 1, 3, 2)).contentToString())
}

class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { i -> freq[i] = freq.getOrDefault(i, 0) + 1 }

        val sortedKeys = freq.keys.sortedWith(compareBy({ freq[it] }, { -it })).toTypedArray()

        var p = 0
        for (key in sortedKeys) {
            repeat(freq[key]!!) {
                nums[p++] = key
            }
        }
        return nums
    }
}
