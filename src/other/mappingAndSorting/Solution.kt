package other.mappingAndSorting

fun main() {
    println(Solution().sortJumbled(intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6), intArrayOf(0, 338, 38)).contentToString())
}

class Solution {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val newNums = mapping.withIndex().associate { (index, value) -> index.toString() to value }
        val numsCost = nums.associateWith { num ->
            val newNum = StringBuilder()
            val chars = num.toString().toCharArray()
            val leadingZeroCount = chars.takeWhile { it == '0' }.count()

            for (char in chars.drop(leadingZeroCount)) {
                newNum.append(newNums[char.toString()])
            }
            newNum.toString().toIntOrNull() ?: 0
        }

        return nums.sortedBy { numsCost[it] }.toIntArray()
    }
}
