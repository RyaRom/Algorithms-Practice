package biggestBitwiseAnd

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val max = nums.max();
        var count = 0;
        var maxCount = 0
        for (element in nums) {
            if (element == max) {
                count++;
            } else {
                maxCount = maxCount.coerceAtLeast(count);
                count = 0;
            }
        }
        return maxCount
    }
}