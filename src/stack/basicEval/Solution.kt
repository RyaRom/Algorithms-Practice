package stack.basicEval

import java.util.*

fun main() {
    println(Solution().calculate("  -2 -2"))
}

class Solution {
    fun calculate(str: String): Int {
        var s = str
        if (Regex("^ *-").find(str) != null) {
            s = str.replaceFirst(Regex("^ *-"), "0-")
        }
        s = s.replace(Regex("\\( *-"), "(0-")
        val regex = Regex("\\d+|[-+()]")
        val nums = Stack<Int>()
        val ops = Stack<Char>()
        for (token in regex.findAll(s)) {
            when (val value = token.value) {
                "+" -> {
                    ops.push('+')
                }

                "-" -> {
                    ops.push('-')
                }

                "(" -> {
                    ops.push('(')
                }

                ")" -> {
                    calc(nums, ops)
                }

                else -> {
                    nums.push(value.toInt())
                }
            }
        }
        calc(nums, ops)
        return nums.pop()
    }

    private fun calc(nums: Stack<Int>, ops: Stack<Char>) {
        val numsC = Stack<Int>()
        val opsC = Stack<Char>()
        while (ops.isNotEmpty()) {
            val op = ops.pop()
            if (op == '(') {
                break
            }
            opsC.push(op)
            numsC.push(nums.pop())
        }
        numsC.push(nums.pop())

        while (opsC.isNotEmpty()) {
            val op = opsC.pop()
            val a = numsC.pop()
            val b = numsC.pop()
            when (op) {
                '+' -> numsC.push(a + b)
                '-' -> numsC.push(a - b)
            }
        }
        nums.push(numsC.pop())
    }
}