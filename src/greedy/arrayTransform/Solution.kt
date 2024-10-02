package greedy.arrayTransform

fun main() {
    println(Solution().arrayRankTransform(intArrayOf(30, 20, 40, 10)).contentToString())
}

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        if (arr.isEmpty()) return arr
        val sortedArr = arr.sorted();
        val map = HashMap<Int, Int>()
        var rang = 1
        map[sortedArr[0]] = rang
        for (i in 1 until arr.size) {
            if (sortedArr[i] != sortedArr[i - 1]) {
                rang++
            }
            map[sortedArr[i]] = rang
        }
        return arr.map { map[it]!! }.toIntArray()
    }
}