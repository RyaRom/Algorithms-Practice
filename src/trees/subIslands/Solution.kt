package trees.subIslands


fun main() {
    val grid1 = arrayOf(
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 1, 1)
    )

    val grid2 = arrayOf(
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(0, 0, 1, 1, 1),
        intArrayOf(0, 1, 0, 0, 0),
        intArrayOf(1, 0, 1, 1, 0),
        intArrayOf(0, 1, 0, 1, 0)
    )
    println(Solution().countSubIslands(grid1, grid2))
}

class Solution {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var subIslands = 0
        for ((i, grid) in grid2.withIndex()) {
            for ((j, e) in grid.withIndex()) {
                if (e == 1) subIslands += isSubIsland(i, j, grid1, grid2)
            }
        }
        return subIslands
    }

    private fun isSubIsland(x: Int, y: Int, grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        if (x < 0 || y < 0 || x >= grid1.size || y >= grid1[x].size || grid2[x][y] != 1) return 1
        if (grid1[x][y] == 0) return 0
        grid2[x][y] = 2
        return minOf(
            isSubIsland(x - 1, y, grid1, grid2),
            isSubIsland(x + 1, y, grid1, grid2),
            isSubIsland(x, y - 1, grid1, grid2),
            isSubIsland(x, y + 1, grid1, grid2)
        )
    }
}