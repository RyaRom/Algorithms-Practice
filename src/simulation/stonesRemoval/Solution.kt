package simulation.stonesRemoval

// 1 1 0 0 0
// 1 0 1 0 0
// 0 1 1 0 0
// 0 0 0 0 0
// 0 0 0 0 0
fun main() {
    val stones: Array<IntArray> = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(2, 2)
    )
    print(Solution().removeStones(stones))
}

class Solution {
    fun removeStones(stones: Array<IntArray>): Int {
        var count = 0
        val stoneSet = stones.toSet()
        val visited: MutableSet<IntArray> = mutableSetOf()
        for (stone in stones) {
            count += removeStoneCluster(stone, stoneSet, visited) - 1
        }
        return count
    }

    private fun removeStoneCluster(stoneCurrent: IntArray, stones: Set<IntArray>, visited: MutableSet<IntArray>): Int {
        if (!visited.add(stoneCurrent)) return 1
        var count = 1
        for (stone in stones) {
            if (!visited.contains(stone) && (stone[0] == stoneCurrent[0] || stone[1] == stoneCurrent[1])) {
                count += removeStoneCluster(stone, stones, visited)
            }
        }
        return count
    }
}