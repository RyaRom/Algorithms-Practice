package binarySearch.kthSmallestDistance

fun main() {
    println(Solution().smallestDistancePair(intArrayOf(1,6,1), 2))
}

class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        val size = nums.size

        var low = 0
        var high = nums[size - 1] - nums[0]

        while (low < high) {
            val mid = (low + high) / 2
            val count = countPairs(nums, mid)

            if (count < k) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }

    private fun countPairs(nums: IntArray, maxDistance: Int): Int {
        var count = 0
        val size = nums.size
        var left = 0;

        for (right in 0 until size) {
            while (nums[right] - nums[left] > maxDistance) ++left
            count += right - left
        }
        return count
    }
}