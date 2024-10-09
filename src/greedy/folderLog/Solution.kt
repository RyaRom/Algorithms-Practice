package greedy.folderLog

fun main() {
    println(Solution().minOperations(arrayOf("./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/")))
}

class Solution {
    fun minOperations(logs: Array<String>): Int {
        var currentDepth = 0
        for (dir in logs) {
            when {
                dir == "../" -> currentDepth = maxOf(0, currentDepth - 1)
                dir != "./" && dir.endsWith("/") -> currentDepth++
            }
        }
        return currentDepth
    }
}
