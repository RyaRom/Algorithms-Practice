package backtracking.maxUniqueSplit

fun main() {
    println(Solution().maxUniqueSplit("aba"))
}

class Solution {
    fun maxUniqueSplit(s: String): Int {
        val set = HashSet<String>()
        return backtrack(s, set)
    }

    private fun backtrack(str: String, visited: HashSet<String>): Int {
        var max = 1
        for (i in 1 until str.length) {
            val deleted = str.substring(0, i)
            val new = str.substring(i, str.length)
            if (deleted in visited) continue
            val newVisited = HashSet<String>(visited)
            newVisited.add(deleted)
            val newCount = 1 + backtrack(new, newVisited)
            max = maxOf(max, newCount)
        }
        if (str in visited) max -= 1
        return max
    }
}