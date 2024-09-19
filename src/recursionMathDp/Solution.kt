package recursionMathDp

fun main() {
    println(Solution().diffWaysToCompute("1+2+3"))
}

class Solution {
    companion object {
        val memory = mutableMapOf<Pair<Int, Int>, List<Int>>()
    }

    fun diffWaysToCompute(expression: String): List<Int> {
        memory.clear()

        val numsRegex = Regex("\\d+")
        val operationsRegex = Regex("[-+*/]")
        val nums = numsRegex.findAll(expression)
            .map { it.value.toInt() }.toList()
        val operations = operationsRegex.findAll(expression)
            .map { it.value.first() }.toList()
        return computeExpression(0, nums.size - 1, nums, operations)
    }

    private fun computeExpression(
        leftIndex: Int,
        rightIndex: Int,
        nums: List<Int>,
        operations: List<Char>,
    ): List<Int> {
        if (leftIndex == rightIndex) return listOf(nums[leftIndex])
        if (memory.contains(Pair(leftIndex, rightIndex))) return memory[Pair(leftIndex, rightIndex)]!!
        if (rightIndex - leftIndex == 1) return listOf(
            compute(
                nums[leftIndex],
                nums[rightIndex],
                operations[leftIndex]
            )
        )
        val result = mutableListOf<Int>()
        for (delim in leftIndex until rightIndex) {
            val left = computeExpression(leftIndex, delim, nums, operations)
            val right = computeExpression(delim + 1, rightIndex, nums, operations)
            for (l in left) {
                for (r in right) {
                    result.add(compute(l, r, operations[delim]))
                }
            }
        }
        memory[Pair(leftIndex, rightIndex)] = result
        return result
    }

    private fun compute(left: Int, right: Int, operation: Char): Int {
        return when (operation) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            '/' -> left / right
            else -> 0
        }
    }
}