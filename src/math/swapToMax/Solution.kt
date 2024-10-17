package math.swapToMax

fun main() {
    println(Solution().maximumSwap(2736))
}

class Solution {
    fun maximumSwap(num: Int): Int {
        val nums = num.toString().toCharArray()
        val numsSorted = nums.sortedByDescending { it.code }
        for (i in numsSorted.indices) {
            if (nums[i] == numsSorted[i]) continue
            else {
                val foundChar = nums[i]
                nums[i] = numsSorted[i]
                val newIndex = nums.lastIndexOf(numsSorted[i])
                nums[newIndex] = foundChar
                break
            }
        }
        return String(nums).toInt()
    }
}