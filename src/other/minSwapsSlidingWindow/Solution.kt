package other.minSwapsSlidingWindow

fun main() {
    println(Solution().minSwaps(intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 0)))
}

class Solution {
    fun minSwaps(nums: IntArray): Int {
        val oneCount = nums.count { it == 1 }
        val numsCircular = IntArray(nums.size * 2)

        for (i in nums.indices) {
            numsCircular[i] = nums[i]
            numsCircular[i + nums.size] = nums[i]
        }

        var current = numsCircular.take(oneCount).count { it == 0 }
        var minSwaps = current
        var p1 = 0
        var p2 = oneCount

        while (p2 < numsCircular.size) {
            if (numsCircular[p1] == 0) current--
            if (numsCircular[p2] == 0) current++
            minSwaps = minOf(minSwaps, current)
            p1++
            p2++
        }
        return minSwaps
    }
}
