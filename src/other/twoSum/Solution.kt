package other.twoSum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, MutableList<Int>>()
        for ((index, n) in nums.withIndex()) {
            map.putIfAbsent(n, mutableListOf())
            map[n]!!.add(index)
        }

        for ((index, n) in nums.withIndex()) {
            val other = target - n
            if (map.contains(other)) {
                val indices = map[other]!!
                if (indices.size == 1 && indices[0] == index) {
                    continue
                }
                val otherIndex = if (indices[0] == index) indices[1] else indices[0]
                return intArrayOf(index, otherIndex)
            }
        }
        return intArrayOf()
    }
}