package math.fractionMathSim

fun main() {
    println(Solution().fractionAddition("-5/2+10/3+7/9"))
}

class Solution {
    fun fractionAddition(expression: String): String {
        val regex = Regex("[+\\-]?\\d+")
        val nums = ArrayList<Pair<Int, Int>>()
        val bottoms = ArrayList<Int>()
        val iter = regex.findAll(expression).iterator()
        while (iter.hasNext()) {
            val a = iter.next().value.toInt()
            val b = iter.next().value.toInt()
            nums.add(Pair(a, b))
            bottoms.add(b)
        }
        var LCM = lcm(bottoms)
        var sum = nums.sumOf { (a, b) ->
            val multiplication = LCM / b
            a * multiplication
        }
        val div = gcd(sum, LCM)
        LCM /= div
        sum /= div
        if (LCM < 0) {
            LCM = -LCM
            sum = -sum
        }
        return "$sum/$LCM"
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    private fun lcm(a: Int, b: Int): Int {
        return a * (b / gcd(a, b))
    }

    private fun lcm(nums: List<Int>): Int {
        return nums.reduce { a, b -> lcm(a, b) }
    }
}