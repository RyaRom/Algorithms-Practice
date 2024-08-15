package lemonadeChange

fun main() {
    println(Solution().lemonadeChange(intArrayOf(5, 5, 5, 10, 5, 5, 10, 20, 20, 20)))
}

class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var collected5 = 0
        var collected10 = 0
        for (bill in bills) {
            when (bill) {
                5 -> collected5++
                10 -> {
                    if (collected5 > 0) {
                        collected5--
                        collected10++
                    } else return false
                }

                20 -> {
                    if (collected10 > 0 && collected5 > 0) {
                        collected10--
                        collected5--
                    } else if (collected5 > 2) collected5 -= 3
                    else return false
                }
            }
        }
        return true
    }
}