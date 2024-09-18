package largestNumCompose

class Solution {
    fun largestNumber(nums: IntArray): String {
        val sortedNum = nums.sortedWith() { a, b -> compare(a, b) }
        val max = sortedNum.map { n -> n.toString() }.reduce { st, s -> st + s }
        return if (max.startsWith("0")) "0"
        else max
    }

    private fun compare(a: Int, b: Int): Int {
        if (a == b) return 0
        val s1 = (a.toString() + b.toString()).toLong()
        val s2 = (b.toString() + a.toString()).toLong()
        return if (s1 < s2) 1
        else -1
    }
}